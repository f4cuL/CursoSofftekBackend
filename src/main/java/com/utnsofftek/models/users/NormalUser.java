package com.utnsofftek.models.users;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("normal")
public class NormalUser extends Usuario{
	@Column
	public String nombre;
	@Column
	public String apellido;
	@Column
	public String email;
}
