package com.utnsofftek.models.users;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("empleado")
@Table(name="user_empleado")
public class Empleado extends Usuario{
	@Column
	private String nombre;
	@Column
	private String apellido;
	//TODO Supervisor??
}
