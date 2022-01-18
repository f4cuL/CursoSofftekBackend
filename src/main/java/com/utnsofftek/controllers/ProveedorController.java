package com.utnsofftek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.Proveedor;
import com.utnsofftek.models.dao.ProveedorDAO;

@RestController
public class ProveedorController{
	
	@Autowired
	ProveedorDAO provDAO;

	@GetMapping("/proveedores")
	public List<Proveedor> findAll() {
		return provDAO.findAll();
	}

	@GetMapping("/proveedor")
	public Proveedor findbyId(@RequestParam int id) {
		return provDAO.findById(id);
	}

	@PostMapping("/proveedor")
	public void agregarProveedor(@RequestBody Proveedor p) {
		provDAO.agregarProveedor(p);
	}

	@DeleteMapping("/proveedor")
	public void eliminarProveedor(@RequestParam int id) {
		provDAO.eliminarProveedor(id);
	}

}
