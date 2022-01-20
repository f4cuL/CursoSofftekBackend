package com.utnsofftek.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@Embeddable
public class DetalleOrdenKey implements Serializable {

		@Column(name = "id_orden")
	    int idOrden;

	    @Column(name = "id_producto")
	    int idProducto;
}
