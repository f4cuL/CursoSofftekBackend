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

import com.utnsofftek.models.Categoria;
import com.utnsofftek.models.dao.CategoriaDAO;

@RestController
public class CategoriaController {

	@Autowired
	CategoriaDAO catDAO;
	@PostMapping("/categoria")
	public boolean agregarCategoria(@RequestBody Categoria categoria) {
		try {
			catDAO.agregar(categoria);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;		
		}
	}
	@GetMapping("/categoria")
	public List<Categoria> traerCategorias(){
		return catDAO.findAll();
	}
	@GetMapping("/categoria/{id}")
	public Categoria traerCategoria(@PathVariable int id) {
		return catDAO.findById(id);
	}
	
	@DeleteMapping("/categoria/{id}")
	public boolean borrarCategoria(@PathVariable int id) {
		try {
			catDAO.eliminar(id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	@PutMapping("/categoria/{id}")
	public boolean editarCategoria(@PathVariable int id, @RequestBody Categoria p) {
		try {
			catDAO.editar(p,id);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
}
