package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Producto;
import com.utnsofftek.models.Proveedor;

@Component
public class ProductoDAO extends HibernateEM {

	public Producto findById(int id) {
		EntityManager em = this.getEmf().createEntityManager();
		try{
			return em.find(Producto.class, id);
		}finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Producto> findAll() {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			return em.createQuery("FROM Producto").getResultList();
		}finally {
			em.close();
		}
	}

	public void agregarProducto(int id, Producto p) {
		EntityManager em = this.getEmf().createEntityManager();
		Proveedor proveedor = em.find(Proveedor.class, id);
		try {
			em.getTransaction().begin();
			proveedor.agregarProducto(p);
			em.merge(proveedor);
			em.getTransaction().commit();
		}finally {
			em.close();
		}
	

	}

	public void modificarProducto(int id, Producto p) {
		EntityManager em = this.getEmf().createEntityManager();
		Producto pFind = em.find(Producto.class, id);
		try {
			em.getTransaction().begin();
			pFind.setNombreProducto(p.getNombreProducto());
			pFind.setPrecioProducto(p.getPrecioProducto());
		}finally {
			em.close();
		}

	}

	public void borrarProducto(int id) {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(findById(id));
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	
	}

}
