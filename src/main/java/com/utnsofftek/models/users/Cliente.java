package com.utnsofftek.models.users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.utnsofftek.models.Orden;
import com.utnsofftek.models.enumerators.TipoCliente;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("cliente")
@Table(name="user_cliente")
public class Cliente extends Usuario{
	@Column
	public String nombre;
	@Column
	public String apellido;
	@Column(name="razon_social")
	public String razonSocial;
	@Column
	public int dni;
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_cliente")
	public TipoCliente tipoCliente;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	List<Orden> listaOrdenes;
	
	public Cliente() {
		this.listaOrdenes=new ArrayList<Orden>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	
}
