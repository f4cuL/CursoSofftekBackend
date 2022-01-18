package com.utnsofftek.controllers;

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
	public void modificarProducto(@RequestParam("id") int id, @RequestBody Producto p)
	{
		pDAO.modificarProducto(id, p);
	}
	@PostMapping("/producto")
	public void insertarProducto(@RequestBody Producto p)
	{
		pDAO.agregarProducto(p);
	}
	@DeleteMapping("/producto")
	public void borrarProducto(@RequestParam("id") int id) {
		pDAO.borrarProducto(id);
	}
	@GetMapping("/productos")
	public List<Producto> traerProductos()
	{
		return pDAO.findAll();	
	}

}
