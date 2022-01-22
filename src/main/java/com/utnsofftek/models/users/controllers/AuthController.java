package com.utnsofftek.models.users.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.users.Usuario;
import com.utnsofftek.models.users.dao.UsuarioDAO;

@RestController
public class AuthController{
	@Autowired
	UsuarioDAO usDAO;
	
	@PostMapping("/usuario/login")
	public Usuario verifyLogin(@Valid @RequestBody Usuario u) {
		Usuario usuario = usDAO.iniciarSesion(u);
		if (usuario ==null) {
			Usuario us = new Usuario();
			us.setNombreUsuario("ERROR");
			us.setPassword("ERROR");
			return us;
		}
		return usuario;
	}
}

