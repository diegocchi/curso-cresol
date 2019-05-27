package br.com.cresol.ws;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.cresol.dao.UsuarioDAO;
import br.com.cresol.model.Abastecimento;
import br.com.cresol.model.Usuario;

@Stateless
@Path("usuario")
public class UsuarioWs {
	
	@EJB
	private UsuarioDAO usuarioDAO;

	@POST
	@Path("entrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response entrar(Usuario usuario) {
		try {
			usuario = usuarioDAO.login(usuario.getEmail(), usuario.getSenha());
			Thread.sleep(2000);
			return Response.ok(usuario).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage())
					.build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Usuario obj) {
		try {
			obj = usuarioDAO.inserir(obj);
			
			return Response.ok(obj).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getLocalizedMessage())
					.build();
		}
	}
	
}

