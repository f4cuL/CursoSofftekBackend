package com.utnsofftek.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utnsofftek.models.users.Cliente;
import com.utnsofftek.models.users.Empleado;

@Entity
@Table

public class Orden extends PersistentEntity{
	@JsonBackReference
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
	//TODO TDO para Cliente
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public java.sql.Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(java.sql.Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public java.sql.Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(java.sql.Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	
	
	
}
