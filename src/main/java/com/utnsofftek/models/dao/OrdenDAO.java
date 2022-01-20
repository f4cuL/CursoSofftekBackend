package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.HibernateEM;
import com.utnsofftek.interfaces.DAOInterface;
import com.utnsofftek.models.Orden;

@Component
public class OrdenDAO extends HibernateEM implements DAOInterface<Orden> {
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

	@Override
	public void agregar(Orden t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Orden t, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	// TODO Terminar Ordend espues de Detalle_orden
}
