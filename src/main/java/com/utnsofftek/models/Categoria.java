package com.utnsofftek.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Categoria extends PersistentEntity{
	@Column(name="nombre_categoria")
	private String nombreCategoria;
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
}
