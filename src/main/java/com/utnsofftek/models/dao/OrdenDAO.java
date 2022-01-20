package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Orden;

@Component
public class OrdenDAO extends HibernateEM {
	public Orden findById(int id) {
		EntityManager em = getEmf().createEntityManager();
		try{
			return em.find(Orden.class, id);
		}finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Orden> findAll() {
		EntityManager em = getEmf().createEntityManager();
		try {
			return em.createQuery("FROM Orden").getResultList();
		}finally {
			em.close();
		}
		
	
	}

	public void agregarOrden(Orden orden) {
		EntityManager em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(orden);
			em.getTransaction().commit();
		}finally {
			em.close();
		}
		
	}

	// TODO ABM
}
