package com.utnsofftek.models.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
			provDAO.agregar(p);
			return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return false;
	}

	@DeleteMapping("/proveedor")
	public boolean eliminarProveedor(@RequestParam int id) {
		try {
			provDAO.eliminar(id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	@PutMapping("/proveedor")
	public boolean modificarProveedor(@RequestBody Proveedor p, @RequestParam int id) {
		try {
			provDAO.editar(p,id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
