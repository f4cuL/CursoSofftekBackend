package com.utnsofftek.models.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Orden;

@Component
public class OrdenDAO extends HibernateEM {
	public Orden findById(int id) {
		return getEm().find(Orden.class, id);
	}

	public List<Orden> findAll() {
		return getEm().createQuery("FROM Orden").getResultList();
	}

	public void agregarOrden(Orden orden) {
		getEm().getTransaction().begin();
		getEm().persist(orden);
		getEm().getTransaction().commit();
	}

	// TODO ABM
}
