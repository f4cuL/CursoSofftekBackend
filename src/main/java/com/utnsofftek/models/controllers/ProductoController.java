package com.utnsofftek.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.Producto;
import com.utnsofftek.models.dao.ProductoDAO;

@RestController
public class ProductoController {
	@Autowired
	ProductoDAO pDAO;
	@GetMapping("/producto/{id}")
	public Producto traerProducto(@PathVariable int id)
	{
		return pDAO.findById(id);	
	}
	@PutMapping("/producto/{id}")
	public boolean modificarProducto(@PathVariable int id, @RequestBody Producto p)
	{
		try {
			pDAO.editar(p,id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@PostMapping("/proveedor/{id}/producto")
	public boolean insertarProducto(@PathVariable("id")int idProveedor,@RequestBody Producto p)
	{
		try {
			pDAO.agregarProductoProveedor(idProveedor, p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@DeleteMapping("/producto/{id}")
	public boolean borrarProducto(@PathVariable("id") int id) {
		try {
			pDAO.eliminar(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}
	@GetMapping("/producto")
	public List<Producto> traerProductos()
	{
		return pDAO.findAll();	
	}

}
