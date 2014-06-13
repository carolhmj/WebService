package com.ws.model.acessobd;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ws.model.entidade.Empresa;


@Path("/empresa")
public class EmpresaBanco {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("ServerWS");
	EntityManager manager = factory.createEntityManager();
	
	@Path("/add")
	@POST
	@Consumes("application/json")
	@Produces("plain/text")
	public String persistirDados(Empresa empresa){
		
		manager.getTransaction().begin();
		manager.persist(empresa);
		manager.getTransaction().commit();
		
		return "Adicionado com sucesso!";
	}
	
	@Path("/pesquisar")
	@GET
	@Consumes("text/plain")
	@Produces("application/json")
	public List<Empresa> retornarDados(String nomeEmpresa){
		
		Query query = manager.createQuery("from Empresa where nomeEmpresa or cnpjEmpresa like " + "'%" + nomeEmpresa + "%'");
		List<Empresa> lista = query.getResultList();
		
		return lista;
	}
	
	@Path("/listar")
	@GET
	@Produces("application/json")
	public List<Empresa> retornarDados(){
		
		Query query = manager.createQuery("from Empresa");
		List<Empresa> lista = query.getResultList();
		
		return lista;
	}
	
	public void fecharFactory(){
		factory.close();
		manager.close();
	}
}
