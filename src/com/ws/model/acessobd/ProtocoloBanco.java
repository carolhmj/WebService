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

import com.ws.model.entidade.Protocolo;


@Path("/protocolo")
public class ProtocoloBanco {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("ServerWS");
	EntityManager manager = factory.createEntityManager();
	
	@Path("/add")
	@POST
	@Consumes("application/json")
	@Produces("plain/text")
	public String persistirDados(Protocolo protocolo){
		
		manager.getTransaction().begin();
		manager.persist(protocolo);
		manager.getTransaction().commit();
		
		return "Adicionado com sucesso!";
	}
	
	@Path("/pesquisar")
	@GET
	@Consumes("text/plain")
	@Produces("application/json")
	public List<Protocolo> retornarDados(String idProtocolo){
		
		Query query = manager.createQuery("from Protocolo where nomeProtocolo like " + "'%" + idProtocolo + "%'");
		List<Protocolo> lista = query.getResultList();
		
		return lista;
	}
	
	@Path("/listar")
	@GET
	@Produces("application/json")
	public List<Protocolo> retornarDados(){
		
		Query query = manager.createQuery("from Protocolo");
		List<Protocolo> lista = query.getResultList();
		
		return lista;
	}
	
	public void fecharFactory(){
		factory.close();
		manager.close();
	}
}
