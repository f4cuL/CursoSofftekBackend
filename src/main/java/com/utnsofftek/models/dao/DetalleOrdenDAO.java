package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.HibernateEM;
import com.utnsofftek.models.DetalleOrden;
import com.utnsofftek.models.DetalleOrdenKey;
import com.utnsofftek.models.Orden;
import com.utnsofftek.models.Producto;

@Component
public class DetalleOrdenDAO extends HibernateEM{

	public List<DetalleOrden> findById(int id) {
		EntityManager em = getEmf().createEntityManager();
		try {
			return em.createQuery("FROM DetalleOrden where id_orden="+id).getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}finally {
			em.close();
		}
	}
	public List<DetalleOrden> findAll() {
		EntityManager em = getEmf().createEntityManager();
		try {
			return em.createQuery("FROM DetalleOrden").getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}finally {
			em.close();
		}	
	}
	public void agregarProducto(int idProducto, int idOrden, int cantidad) {
		EntityManager em = getEmf().createEntityManager();
		try {
			DetalleOrden detalleOrden = new DetalleOrden();
			DetalleOrdenKey detalleOrdenKey = new DetalleOrdenKey();
			detalleOrdenKey.setIdOrden(idOrden);
			detalleOrdenKey.setIdProducto(idProducto);
			detalleOrden.setId(detalleOrdenKey);
			detalleOrden.setCantidad(cantidad);
			detalleOrden.setOrden(em.find(Orden.class, idOrden));
			detalleOrden.setProducto(em.find(Producto.class, idProducto));
			em.getTransaction().begin();
			em.persist(detalleOrden);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
	}
	public void eliminar(int id) {
		EntityManager em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(DetalleOrden.class, id));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
		
	}
}
