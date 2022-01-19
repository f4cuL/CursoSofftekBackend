package com.utnsofftek.models.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.Categoria;
import com.utnsofftek.models.HibernateEM;

@Component
public class CategoriaDAO extends HibernateEM{
	public List<Categoria> findALL() {
		return getEm().createQuery("FROM Categoria").getResultList();
	}
	public void agregarCategoria(Categoria categoria) {
		getEm().getTransaction().begin();
		getEm().persist(categoria);
		getEm().getTransaction().commit();
	}
	
	//TODO ABM
}