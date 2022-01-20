package com.utnsofftek.models.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utnsofftek.models.users.Empleado;
import com.utnsofftek.models.users.dao.EmpleadoDAO;

@RestController
public class EmpleadoController {
	@Autowired
	EmpleadoDAO empDAO;
	
	@GetMapping("/usuario/empleados")
	public List<Empleado> traerEmpleados(){
		return empDAO.findAll();
	}
	
	@PostMapping("/usuario/empleado")
	public boolean crearEmpleado(@RequestBody Empleado empleado) {
		
		try {
			empDAO.agregar(empleado);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
