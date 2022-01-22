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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

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
	@NotBlank
	private String nombre;
	
	@Column
	@NotBlank
	private String apellido;
	
	@Column(name="razon_social")
	@NotBlank
	private String razonSocial;
	
	@Column
	@Positive
	@Range(min = 10000000, max = 99999999)
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
