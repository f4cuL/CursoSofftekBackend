package com.utnsofftek.models.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@GetMapping("/usuario/login")
	public void test() {
		//TODO Hacer el login
	}
}