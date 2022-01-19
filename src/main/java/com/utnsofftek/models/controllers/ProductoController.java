package com.utnsofftek.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.utnsofftek.models.Producto;
import com.utnsofftek.models.dao.ProductoDAO;

@RestController
public class ProductoController {
	@Autowired
	ProductoDAO pDAO;
	@GetMapping("/producto")
	public Producto traerProducto(@RequestParam("id") int id)
	{
		return pDAO.findById(id);	
	}
	@PutMapping("/producto")
	public boolean modificarProducto(@RequestParam("id") int id, @RequestBody Producto p)
	{
		try {
			pDAO.modificarProducto(id, p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@PostMapping("/producto")
	public boolean insertarProducto(@RequestParam("id")int idProveedor,@RequestBody Producto p)
	{
		try {
			pDAO.agregarProducto(idProveedor, p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@DeleteMapping("/producto")
	public boolean borrarProducto(@RequestParam("id") int id) {
		try {
			pDAO.borrarProducto(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}
	@GetMapping("/productos")
	public List<Producto> traerProductos()
	{
		return pDAO.findAll();	
	}

}
