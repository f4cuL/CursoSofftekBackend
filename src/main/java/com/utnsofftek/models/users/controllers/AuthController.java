package com.utnsofftek.models.users.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.users.Usuario;
import com.utnsofftek.models.users.dao.UsuarioDAO;

@RestController
public class AuthController{
	@Autowired
	UsuarioDAO usDAO;
	
	@GetMapping("/login")
	public boolean verifyLogin(@Valid @RequestBody Usuario u) {
		Usuario usuario = usDAO.iniciarSesion(u);
		if (usuario ==null) {
			return false;
		}
		return true;
	}
}

