package com.utnsofftek;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HibernateEM {
	private EntityManagerFactory emf;
	public HibernateEM() {
		this.emf = Persistence.createEntityManagerFactory("db");
	}
	
}
