package com.utnsofftek.models.users;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

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
	
}
