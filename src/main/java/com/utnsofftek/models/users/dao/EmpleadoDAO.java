package com.utnsofftek.models.users.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.users.Empleado;

@Component
public class EmpleadoDAO extends HibernateEM {
	public void agregarEmpleado(Empleado empleado) {
		getEm().getTransaction().begin();
		getEm().persist(empleado);
		getEm().getTransaction().commit();
	}

	public List<Empleado> findAll() {
		return getEm().createQuery("FROM Empleado").getResultList();
	}
}

//TODO ABM