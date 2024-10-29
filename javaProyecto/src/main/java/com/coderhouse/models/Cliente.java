package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Cliente")
	private Long id;
	
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellido")
	private String apellido;
	@Column(name="Cuit", unique = true, nullable = true)
	private String cuit;
	@Column(name="Domicilio")
	private String domicilio;
	
	
	@OneToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	private List<Venta> Ventas = new ArrayList<>();
	
	

	public Cliente() {
		super();
		
	}


	public Cliente(String nombre, String apellido, String cuit, String domicilio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuit = cuit;
		this.domicilio = domicilio;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cuit=" + cuit + ", domicilio="
				+ domicilio + "]";
	}



	
}