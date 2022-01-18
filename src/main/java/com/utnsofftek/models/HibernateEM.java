package com.utnsofftek.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HibernateEM {
	private EntityManager em;
	public HibernateEM() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("db");
		this.em = emf.createEntityManager();
	}
	
}
