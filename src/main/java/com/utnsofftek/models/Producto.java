package com.utnsofftek.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto extends PersistentEntity{
	@JoinColumn(name = "id_proveedor")
	@ManyToOne(targetEntity = Proveedor.class)
	private Proveedor proveedor;
	@Column(name="nombre_producto")
	private String nombreProducto;
	@Column(name="precio_producto")
	private int precioProducto;
}
