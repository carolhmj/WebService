package com.ws.model.acessobd;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ws.model.entidade.Usuario;


@Path("/usuario")
public class UsuarioBanco {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("ServerWS");
	EntityManager manager = factory.createEntityManager();
	
	@Path("/add")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String persistirDados(Usuario usuario){
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		return "Adicionado com sucesso!";
	}
	
	@Path("/pesquisar")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public List<Usuario> retornarDados(String nomeUsuario){
		
		Query query = manager.createQuery("from Usuario where nomeUsuario like " + "'%" + nomeUsuario + "%'");
		List<Usuario> lista = query.getResultList();
		
		return lista;
	}
	
	@Path("/listar")
	@GET
	@Produces("application/json")
	public List<Usuario> retornarDados(){
		
		Query query = manager.createQuery("from Usuario");
		List<Usuario> lista = query.getResultList();
		
		return lista;
	}
	
	public void fecharFactory(){
		factory.close();
		manager.close();
	}
}
