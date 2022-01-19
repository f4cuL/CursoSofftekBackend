package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Producto;
import com.utnsofftek.models.Proveedor;

@Component
public class ProveedorDAO extends HibernateEM {
	@SuppressWarnings("unchecked")
	public List<Proveedor> findAll() {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			return em.createQuery("FROM Proveedor").getResultList();
		} finally {
			em.close();
		}
		
	}
	public Proveedor findById(int id) {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			return em.find(Proveedor.class, id);
		}finally {
			em.close();
		}
		
	}

	public void agregarProveedor(Proveedor p) {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}finally {
			em.close();
		}

	}

	public void eliminarProveedor(int id) {
		EntityManager em = this.getEmf().createEntityManager();
		try{
			em.getTransaction().begin();
			em.remove(findById(id));
			em.getTransaction().commit();
		}finally{
			em.close();
		}
	}

	public void editarProveedor(Proveedor p, int id) {
		EntityManager em = this.getEmf().createEntityManager();
		Proveedor pFind = em.find(Proveedor.class, id);
		pFind.setCuit(p.getCuit());
		pFind.setDireccion(p.getDireccion());
		pFind.setNombre(p.getNombre());
		try {
			em.getTransaction().begin();
			em.merge(pFind);
			em.getTransaction().commit();
		}finally {
			em.close();
		}
	}
	
}
