package com.utnsofftek.models.users.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.HibernateEM;
import com.utnsofftek.models.users.Cliente;

@Component
public class ClienteDAO extends HibernateEM {

	@SuppressWarnings("unchecked")
	public List<Cliente> findAllClientes(){
		EntityManager em = getEmf().createEntityManager();
		try{
			return em.createQuery("FROM Cliente").getResultList();
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}finally {
			em.close();
		}

		
	}
	public void generarUsuario(Cliente u){
		EntityManager em = getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}catch(Exception e){
			System.out.println(e);
		}finally {
			em.close();
		}
	}

}
//TODO ABM