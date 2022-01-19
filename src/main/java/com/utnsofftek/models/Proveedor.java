	package com.utnsofftek.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proovedor")
public class Proveedor extends PersistentEntity{
	
	public Proveedor() {
		this.listaProductos = new ArrayList<Producto>();
	}

	@Column
	private String nombre;
	@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Producto> listaProductos;
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private int cuit;
	
	//TODO FALTA RAZON Categoría 
	
	public void agregarProducto(Producto ... producto) {
		
		for (Producto p : producto) {
			p.setProveedor(this);
			listaProductos.add(p);
		}

	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}