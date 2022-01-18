package com.utnsofftek.models.users.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utnsofftek.models.HibernateEM;
import com.utnsofftek.models.users.NormalUser;
@Component
public class NormalUserDAO extends HibernateEM{

	@SuppressWarnings("unchecked")
	public List<NormalUser> findAllNormalUsers(){
		return getEm().createQuery("FROM NormalUser").getResultList();
	}
	public void generarUsuario(NormalUser u) {
		getEm().getTransaction().begin();
		getEm().persist(u);
		getEm().getTransaction().commit();
	}
	
	public static void main(String[] args) {
		
	}
}
