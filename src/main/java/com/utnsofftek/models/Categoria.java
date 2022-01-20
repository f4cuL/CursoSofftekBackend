package com.utnsofftek.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.utnsofftek.PersistentEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria extends PersistentEntity{
	@Column(name="nombre_categoria")
	private String nombreCategoria;
}
