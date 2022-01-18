package com.utnsofftek.models.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Producto;

@Component
public class ProductoDAO extends HibernateEM{
	
	public Producto findById(int id) {
		return getEm().find(Producto.class,id);
	}
	@SuppressWarnings("unchecked")
	public List<Producto> findAll() {
		return getEm().createQuery("FROM Producto").getResultList();
	}
	public void agregarProducto(Producto p) {
		getEm().getTransaction().begin();
		getEm().persist(p);
		getEm().getTransaction().commit();
	}
	public void modificarProducto(int id, Producto p) {
		Producto pFind = getEm().find(Producto.class, id);
		getEm().getTransaction().begin();
		pFind.setNombreProducto(p.getNombreProducto());
		pFind.setPrecioProducto(p.getPrecioProducto());
		getEm().getTransaction().commit();
	}
	public void borrarProducto(int id) {
		getEm().getTransaction().begin();
		getEm().remove(findById(id));
		getEm().getTransaction().commit();
	}
	
}
