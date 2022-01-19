package com.utnsofftek.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.Orden;
import com.utnsofftek.models.dao.OrdenDAO;

@RestController
public class OrdenController {
	@Autowired
	OrdenDAO oDAO;
	@GetMapping("/orden")
		public Orden traerOrden(@RequestParam int id) {
			return oDAO.findById(id);
	};
	@GetMapping("/ordenes")
	public List<Orden> traerOrdenes() {
		return oDAO.findAll();
	}
	@PostMapping("/orden")
	public boolean agregarOrden(@RequestBody Orden orden){
		try {
			oDAO.agregarOrden(orden);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			oDAO.getEm().getTransaction().rollback();
			return false;
		}
	}
}
