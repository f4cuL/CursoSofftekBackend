package com.utnsofftek.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.DetalleOrden;
import com.utnsofftek.models.dao.DetalleOrdenDAO;

@RestController
public class DetalleOrdenController {
	@Autowired
	DetalleOrdenDAO dODAO;
	@PostMapping("/orden/{idOrden}/detalle/producto/{idProducto}/{cantidad}")
	public void agregarDetalleOrden(@PathVariable int idOrden, @PathVariable int idProducto, @PathVariable int cantidad){
		try {
			dODAO.agregarProducto(idProducto, idOrden, cantidad);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	@GetMapping("/orden/detalle")
	public List<DetalleOrden> obtenerDetalleOrden(){
		return dODAO.findAll();
	}
	@GetMapping("/orden/{id}/detalle")
	public List<DetalleOrden> obtenerDetalleOrdenId(@PathVariable int id){
		return dODAO.findById(id);
	}
}
