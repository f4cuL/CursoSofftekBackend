package com.utnsofftek.models;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalle_orden")
public class DetalleOrden{
	
	@EmbeddedId
    DetalleOrdenKey id;
	
	@MapsId("idOrden")
	@JoinColumn(name="id_orden")
	@JsonIgnore
	@ManyToOne(targetEntity = Orden.class, cascade = CascadeType.ALL)
	private Orden orden;
	@MapsId("idProducto")
	@JoinColumn(name="id_producto")
	@ManyToOne(targetEntity = Producto.class, cascade = CascadeType.ALL)
	private Producto producto;
	
	int cantidad;
}
