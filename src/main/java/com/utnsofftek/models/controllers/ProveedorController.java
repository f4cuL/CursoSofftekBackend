package com.utnsofftek.models.controllers;

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
	public List<Proveedor> traerProveedores() {
		return provDAO.findAll();
	}

	@GetMapping("/proveedor")
	public Proveedor traerProveedor(@RequestParam int id) {
		return provDAO.findById(id);
	}

	@PostMapping("/proveedor")
	public boolean agregarProveedor(@RequestBody Proveedor p) {
		try {
			if(p.getCuit()!=0) {
			provDAO.agregarProveedor(p);
			return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			provDAO.getEm().getTransaction().rollback();
			return false;
		}
		return false;
	}

	@DeleteMapping("/proveedor")
	public boolean eliminarProveedor(@RequestParam int id) {
		try {
			provDAO.eliminarProveedor(id);
			return true;
		} catch (Exception e) {
			provDAO.getEm().getTransaction().rollback();
			return false;
		}
	}

}