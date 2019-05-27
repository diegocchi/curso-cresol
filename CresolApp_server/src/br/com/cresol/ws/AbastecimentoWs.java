package br.com.cresol.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.cresol.dao.AbastecimentoDAO;
import br.com.cresol.model.Abastecimento;

@Stateless
@Path("abastecimento")
public class AbastecimentoWs {

	@EJB
	private AbastecimentoDAO dao;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Abastecimento obj) {
		try {
			obj = dao.inserir(obj);
			
			return Response.ok(obj).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage())
					.build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id")Long id) {
		try {
			Abastecimento obj = dao.buscar(id);
			return Response.ok(obj).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage())
					.build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletar(@PathParam("id")Long id) {
		try {
			dao.remover(id);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage())
					.build();
		}
	}
	
	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTodos() {
		try {
			List<Abastecimento> obj = dao.buscarTodos();
			return Response.ok(obj).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage())
					.build();
		}
	}
}
