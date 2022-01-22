package com.utnsofftek.models.users.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.password4j.Password;
import com.utnsofftek.HibernateEM;
import com.utnsofftek.models.users.Usuario;

@Component
public class UsuarioDAO extends HibernateEM{
	public Usuario iniciarSesion(Usuario usuario) {
		EntityManager em = getEmf().createEntityManager();
		List<Usuario> u = em.createQuery("from Usuario where nombreUsuario=:nombre")
				.setParameter("nombre", usuario.getNombreUsuario()).getResultList();
		if (u.isEmpty()) {
			return null;
		}
		String passwordHashed = u.get(0).getPassword();
		Boolean verified = Password.check(usuario.getPassword(), passwordHashed).withBCrypt();
		if (verified) {
			return u.get(0);
		} else {
			return null;
		}
		
	}
}
