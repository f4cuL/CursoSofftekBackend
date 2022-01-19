package com.utnsofftek.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.utnsofftek.models.users.Cliente;
import com.utnsofftek.models.users.Empleado;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Orden extends PersistentEntity{
	@ManyToOne(targetEntity = Cliente.class)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	@JoinColumn(name="id_vendedor")
	@OneToOne(optional = true)
	private Empleado empleado;
	@Column(name="fecha_generacion")
    private java.sql.Date fechaGeneracion;
	@Column(name="fecha_entrega")
    private java.sql.Date fechaEntrega;
	@Column(name="precio_total")
	private int precioTotal;
	
}
