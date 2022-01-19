	package com.utnsofftek.models;

import java.util.ArrayList;
import java.util.List;

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
		this.listaProductos = new ArrayList<Producto>();
	}

	@Column
	private String nombre;
	@JsonManagedReference
	@OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Producto> listaProductos;
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private int cuit;
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "proveedor_categoria", joinColumns = {
			@JoinColumn(name = "id_proveedor") },
			inverseJoinColumns = { @JoinColumn(name = "id_categoria") })
	private List<Categoria> listaCategorias;
	
	//TODO POJO categorias y cliente para orden - cliente
	
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
	public Proveedor(List<Producto> listaProductos) {
		this.listaProductos = new ArrayList<>();
	}
	
}