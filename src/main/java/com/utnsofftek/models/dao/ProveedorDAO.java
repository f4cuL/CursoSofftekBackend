package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.utnsofftek.HibernateEM;
import com.utnsofftek.interfaces.DAOInterface;
import com.utnsofftek.models.Proveedor;

@Component
public class ProveedorDAO extends HibernateEM implements DAOInterface<Proveedor>{
	@SuppressWarnings("unchecked")
	public List<Proveedor> findAll() {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			List<Proveedor> listaObtenida = em.createQuery("FROM Proveedor").getResultList();
			for (Proveedor p : listaObtenida) {
				Hibernate.initialize(p.getListaCategorias());
				Hibernate.initialize(p.getListaProductos());
			}
			return listaObtenida;
		}catch (Exception e) {
			System.out.println("e");
			return null;
		}finally {
			em.close();
		}		
	}

	public Proveedor findById(int id) {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			Proveedor p = em.find(Proveedor.class, id);
			Hibernate.initialize(p.getListaProductos());
			Hibernate.initialize(p.getListaCategorias());
			return p;
		} catch (Exception e) {
			System.out.println("e");
			return null;
		} finally {
			em.close();
		}

	}

	public void agregar(Proveedor p) {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} finally {
			em.close();
		}

	}

	public void eliminar(int id) {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Proveedor.class, id));
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public void editar(Proveedor p, int id) {
		EntityManager em = this.getEmf().createEntityManager();
		Proveedor pFind = em.find(Proveedor.class, id);
		pFind.setCuit(p.getCuit());
		pFind.setDireccion(p.getDireccion());
		pFind.setNombre(p.getNombre());
		try {
			em.getTransaction().begin();
			em.merge(pFind);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}

