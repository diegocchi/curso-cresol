package br.com.cresol.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class ApplicationRest extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> sets = new HashSet<>();
		sets.add(UsuarioWs.class);
		sets.add(AbastecimentoWs.class);
		sets.add(CrossFilterOrigin.class);
		return sets;
	}
}
