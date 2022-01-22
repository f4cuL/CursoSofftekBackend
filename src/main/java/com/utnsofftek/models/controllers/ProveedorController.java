package com.utnsofftek.models.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.Proveedor;
import com.utnsofftek.models.dao.ProveedorDAO;

@RestController
public class ProveedorController{
	
	@Autowired
	ProveedorDAO provDAO;

	@GetMapping("/proveedor")
	public List<Proveedor> traerProveedores() {
		return provDAO.findAll();
	}

	@GetMapping("/proveedor/{id}")
	public Proveedor traerProveedor(@PathVariable int id) {
		return provDAO.findById(id);
	}

	@PostMapping("/proveedor")
	public void agregarProveedor(@Valid @RequestBody Proveedor p) {
		provDAO.agregar(p);
	}

	@DeleteMapping("/proveedor/{id}")
	public boolean eliminarProveedor(@PathVariable int id) {
		try {
			provDAO.eliminar(id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	@PutMapping("/proveedor/{id}")
	public void modificarProveedor(@Valid @RequestBody Proveedor p, @PathVariable int id) {
			provDAO.editar(p,id);
	}

}
