package com.utnsofftek.models.users;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utnsofftek.models.Orden;
import com.utnsofftek.models.enumerators.TipoCliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("cliente")
@Table(name="user_cliente")
public class Cliente extends Usuario{
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column(name="razon_social")
	private String razonSocial;
	@Column
	private int dni;
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_cliente")
	private TipoCliente tipoCliente;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
	Set<Orden> listaOrdenes;

	public void agregarOrden(Orden ... orden) {
		for (Orden o : orden) {
			o.setCliente(this);
			listaOrdenes.add(o);
		}
	}
	
	public Cliente() {
		this.listaOrdenes=new HashSet<Orden>();
	}
	
	
	
}
