	package com.utnsofftek.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "proovedor")
@Transactional
public class Proveedor extends PersistentEntity{
	
	public Proveedor() {
		this.listaProductos =new HashSet<>();
	}

	@Column
	private String nombre;
	@JsonManagedReference
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Producto> listaProductos;
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
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
	
}