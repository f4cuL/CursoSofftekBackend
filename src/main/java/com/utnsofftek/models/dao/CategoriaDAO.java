package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.Categoria;
import com.utnsofftek.models.HibernateEM;

@Component
public class CategoriaDAO extends HibernateEM{
	public List<Categoria> findALL() {
		EntityManager em = getEmf().createEntityManager();
		try {
			return em.createQuery("FROM Categoria").getResultList();
		} finally {
			em.close();
		}

		
	}
	public void agregarCategoria(Categoria categoria) {
		EntityManager em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}
	
	//TODO ABM
}