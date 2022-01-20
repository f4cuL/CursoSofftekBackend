package com.utnsofftek.models.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.password4j.Hash;
import com.password4j.Password;
import com.utnsofftek.models.users.Cliente;
import com.utnsofftek.models.users.dao.ClienteDAO;

@RestController
public class ClienteController {
	@Autowired
	ClienteDAO cliDAO;
	@GetMapping("/usuario/clientes")
	public List<Cliente> findAllUsers(){
		return cliDAO.findAllClientes();
	}
	@PostMapping("/usuario/cliente")
	public boolean agregarUsuario(@RequestBody Cliente u) {
		Hash hash = Password.hash(u.getPassword()).withBCrypt();
		u.setPassword(hash.getResult());
		try {
			cliDAO.generarUsuario(u);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
}
