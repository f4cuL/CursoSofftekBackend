package com.utnsofftek.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/orden/{id}")
		public Orden traerOrden(@PathVariable int id) {
			return oDAO.findById(id);
	};
	@GetMapping("/orden")
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
			return false;
		}
	}
}
