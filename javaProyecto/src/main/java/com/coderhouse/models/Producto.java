package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Producto")
	private Long id;
	
	@Column(name="Descripcion", nullable = false)
	private String descripcion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "producto_cliente",
			joinColumns = @JoinColumn(name = "Id_Clientes"),
			inverseJoinColumns = @JoinColumn(name = "Id_Productos")
			)
	private List<Cliente> clientes = new ArrayList<>();



	public Producto() {
		super();
		
	}



	public Producto(String descripcion) {
		this.descripcion = descripcion;
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", clientes=" + clientes + "]";
	}

	

	
}
