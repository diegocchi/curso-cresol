package br.com.cresol.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import br.com.cresol.model.Abastecimento;
import br.com.cresol.model.Usuario;

@LocalBean
@Stateless
public class UsuarioDAO extends AbstractDAO {

	public Usuario login(String email,String senha) throws Exception {
		String sql = "Select u From Usuario u where upper(u.email) = :email"
				+ " and upper(u.senha) = :senha ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("email", email.trim().toUpperCase());
		query.setParameter("senha", senha.trim().toUpperCase());
		List<Usuario> usuarios = query.getResultList();
		if (usuarios.isEmpty()) {
			throw new Exception("Usuário ou senha inválidos");
		}
		return usuarios.get(0);
	}
	
	public Usuario inserir(Usuario obj) throws Exception {
		getEntityManager().persist(obj);
		getEntityManager().flush();
		return obj;
	}
	
}
