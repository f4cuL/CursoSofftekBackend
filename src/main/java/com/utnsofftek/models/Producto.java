package com.utnsofftek.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="producto")
public class Producto extends PersistentEntity{
	@JoinColumn(name = "id_proveedor")
	@JsonBackReference
	@ManyToOne(targetEntity = Proveedor.class)
	//TODO Hacer TDO para proveedor
	private Proveedor proveedor;
	@Column(name="nombre_producto")
	private String nombreProducto;
	@Column(name="precio_producto")
	private double precioProducto;
	@Column
	private int stock;
}
