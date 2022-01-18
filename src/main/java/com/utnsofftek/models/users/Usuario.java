package com.utnsofftek.models.users;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.utnsofftek.models.PersistentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public class Usuario extends PersistentEntity{
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	@Column(name="password")
	private String password;
}
