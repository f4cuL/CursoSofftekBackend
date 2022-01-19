package com.utnsofftek.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
			catDAO.agregarCategoria(categoria);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			catDAO.getEm().getTransaction().rollback();
			return false;		
		}
	}
	@GetMapping("/categorias")
	public List<Categoria> traerCategorias(){
		return catDAO.findALL();
	}
}
