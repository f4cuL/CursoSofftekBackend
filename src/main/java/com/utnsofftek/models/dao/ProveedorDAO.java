package com.utnsofftek.models.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Producto;
import com.utnsofftek.models.Proveedor;

@Component
public class ProveedorDAO extends HibernateEM {
	@SuppressWarnings("unchecked")
	public List<Proveedor> findAll() {
		return getEm().createQuery("FROM Proveedor").getResultList();

	}

	public Proveedor findById(int id) {
		return getEm().find(Proveedor.class, id);
	}

	public void agregarProveedor(Proveedor p) {
		getEm().getTransaction().begin();
		getEm().persist(p);
		getEm().getTransaction().commit();
	}

	public void eliminarProveedor(int id) {
		getEm().getTransaction().begin();
		getEm().remove(findById(id));
		getEm().getTransaction().commit();
	}

	public void editarProveedor(Proveedor p, int id) {
		Proveedor pFind = getEm().find(Proveedor.class, id);
		pFind.setCuit(p.getCuit());
		pFind.setDireccion(p.getDireccion());
		pFind.setNombre(p.getNombre());
		getEm().getTransaction().begin();
		getEm().merge(pFind);
		getEm().getTransaction().commit();
		
	}
}
