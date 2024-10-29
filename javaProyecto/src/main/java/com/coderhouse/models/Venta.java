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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_Venta")
	private Long id;
	
	@Column(name="Numero_Venta" , nullable = false) 
	private String numero;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "venta_cliente",
			joinColumns = @JoinColumn(name = "Id_Clientes"),
			inverseJoinColumns = @JoinColumn(name = "Id_Venta")
			)
	private List<Cliente> clientes = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;
	
	public Venta() {
		super();
		
	}

	public Venta(String numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", numero=" + numero + ", clientes=" + clientes + "]";
	}

	
	
	



	
}