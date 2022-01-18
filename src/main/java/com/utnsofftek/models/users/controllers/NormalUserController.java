package com.utnsofftek.models.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.password4j.Hash;
import com.password4j.Password;
import com.utnsofftek.models.users.NormalUser;
import com.utnsofftek.models.users.dao.NormalUserDAO;

@RestController
public class NormalUserController {
	@Autowired
	NormalUserDAO nUDAO;
	@GetMapping("/usuarios")
	public List<NormalUser> findAllUsers(){
		return nUDAO.findAllNormalUsers();
	}
	@PostMapping("/usuario")
	public void agregarUsuario(@RequestBody NormalUser u) {
		Hash hash = Password.hash(u.getPassword()).withBCrypt();
		u.setPassword(hash.getResult());
		nUDAO.generarUsuario(u);
	}
	
}
