package com.utnsofftek.models.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.interfaces.DAOInterface;
import com.utnsofftek.models.Categoria;
import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.Proveedor;

@Component
public class CategoriaDAO extends HibernateEM implements DAOInterface<Categoria> {
	public List<Categoria> findAll() {
		EntityManager em = getEmf().createEntityManager();
		try {
			return em.createQuery("FROM Categoria").getResultList();
		} catch (Exception e) {
			System.out.println("e");
			return null;
		} finally {
			em.close();
		}

	}

	public void agregar(Categoria categoria) {
		EntityManager em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public Categoria findById(int id) {
		EntityManager em = getEmf().createEntityManager();
		try {
			return em.find(Categoria.class, id);
		} catch (Exception e) {
			System.out.println("e");
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void editar(Categoria t, int id) {
		EntityManager em = getEmf().createEntityManager();
		try {
			Categoria catEncontrada = em.find(Categoria.class, id);
			catEncontrada.setNombreCategoria(t.getNombreCategoria());
			em.getTransaction().begin();
			em.merge(catEncontrada);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	@Override
	public void eliminar(int id) {
		EntityManager em = getEmf().createEntityManager();
		try {		
			Categoria catEncontrada = em.find(Categoria.class,id);
			em.getTransaction().begin();
			em.remove(catEncontrada);	
			em.getTransaction().commit();	
		}
		finally {
			em.close();
		}
	}
	public void agregarCategoria(int idProveedor,int idCategoria) {
		EntityManager em = getEmf().createEntityManager();
		try {
			Categoria categoria = em.find(Categoria.class, idCategoria);
			Proveedor proveedor = em.find(Proveedor.class, idProveedor);
			proveedor.agregarCategoria(categoria);
			em.getTransaction().begin();
			em.merge(proveedor);
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
	}
	
}