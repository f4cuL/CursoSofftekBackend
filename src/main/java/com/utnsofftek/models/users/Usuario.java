package com.utnsofftek.models.users;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.utnsofftek.PersistentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Table(name="user")
public class Usuario extends PersistentEntity{
	@NotBlank
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	@NotBlank
	@Column(name="password", nullable = false)
	private String password;
}
