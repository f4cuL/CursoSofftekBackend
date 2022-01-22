package com.utnsofftek.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utnsofftek.PersistentEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "proovedor")
public class Proveedor extends PersistentEntity{
	
	public Proveedor() {
		this.listaProductos =new HashSet<>();
	}

	@Column
	@NotBlank
	private String nombre;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Producto> listaProductos;
	
	@Column
	@NotBlank
	private String direccion;
	
	
	@Column
	@Min(10000000)
	private int cuit;
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinTable(
			name = "proveedor_categoria", joinColumns = {
			@JoinColumn(name = "id_proveedor") },
			inverseJoinColumns = { @JoinColumn(name = "id_categoria") })
	private Set<Categoria> listaCategorias;
	
	public void agregarProducto(Producto ... producto) {
		for (Producto p : producto) {
			p.setProveedor(this);
			listaProductos.add(p);
		}
	}
	public void agregarCategoria(Categoria ... categoria) {
		for (Categoria c : categoria) {
			listaCategorias.add(c);
		}
	}
	public void removerCategoria(int id) {
		for (Categoria c : listaCategorias) {
			if (c.getId()==id) {
				listaCategorias.remove(c);
			}
		}
	}
	
}