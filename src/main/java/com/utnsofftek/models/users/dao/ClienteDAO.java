package com.utnsofftek.models.users.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.users.Cliente;

@Component
public class ClienteDAO extends HibernateEM {

	@SuppressWarnings("unchecked")
	public List<Cliente> findAllClientes() {
		return getEm().createQuery("FROM Cliente").getResultList();
	}

	public void generarUsuario(Cliente u) {
		getEm().getTransaction().begin();
		getEm().persist(u);
		getEm().getTransaction().commit();
	}

}
//TODO ABM