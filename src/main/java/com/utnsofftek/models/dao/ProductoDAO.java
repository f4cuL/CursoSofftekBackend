package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import com.utnsofftek.interfaces.DAOInterface;
import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Producto;
import com.utnsofftek.models.Proveedor;

@Component
public class ProductoDAO extends HibernateEM implements DAOInterface<Producto>{

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

	public void agregarProductoProveedor(int id, Producto p) {
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

	public void editar(Producto p, int id) {
		EntityManager em = this.getEmf().createEntityManager();
		Producto pFind = em.find(Producto.class, id);
		try {
			em.getTransaction().begin();
			pFind.setNombreProducto(p.getNombreProducto());
			pFind.setPrecioProducto(p.getPrecioProducto());
			em.getTransaction().commit();
		}finally {
			em.close();
		}

	}

	public void eliminar(int id) {
		EntityManager em = this.getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Producto.class, id));
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	
	}

	@Override
	public void agregar(Producto t) {		
		//No lo voy a usar ya que no tiene sentido agregar un producto si no es a un Proveedor
	}

}
