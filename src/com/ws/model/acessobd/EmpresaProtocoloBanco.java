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

import com.ws.model.entidade.EmpresaProtocolo;


@Path("/empresaprotocolo")
public class EmpresaProtocoloBanco {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("ServerWS");
	EntityManager manager = factory.createEntityManager();

	@Path("/pesquisar")
	@GET
	@Consumes("text/plain")
	@Produces("application/json")
	public List<EmpresaProtocolo> retornarDados(String idProtocolo){
		
		Query query = manager.createQuery("from EmpresaProtocolo where protocolo like " + "'%" + idProtocolo + "%'");
		List<EmpresaProtocolo> lista = query.getResultList();
		
		return lista;
	}
	
	@Path("/listar")
	@GET
	@Produces("application/json")
	public List<EmpresaProtocolo> retornarDados(){
		
		Query query = manager.createQuery("from EmpresaProtocolo");
		List<EmpresaProtocolo> lista = query.getResultList();
		
		return lista;
	}
	
	public void fecharFactory(){
		factory.close();
		manager.close();
	}
}
