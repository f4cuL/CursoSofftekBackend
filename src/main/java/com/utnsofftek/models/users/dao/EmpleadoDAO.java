package com.utnsofftek.models.users.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.users.Empleado;

@Component
public class EmpleadoDAO extends HibernateEM {
	public void agregar(Empleado empleado) {
		EntityManager em = getEmf().createEntityManager();
		try {
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			em.close();
		}
	}

	public List<Empleado> findAll() {
		EntityManager em = getEmf().createEntityManager();
		try {
			return em.createQuery("FROM Empleado").getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}finally {
			em.close();
		}

	}
}

//TODO ABM