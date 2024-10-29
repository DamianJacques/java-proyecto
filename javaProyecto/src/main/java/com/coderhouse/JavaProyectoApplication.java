package com.coderhouse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;
import com.coderhouse.models.Venta;


@SpringBootApplication
public class JavaProyectoApplication implements CommandLineRunner {
	 
	@Autowired
	private DaoFactory dao;
	

	public static void main(String[] args) {
		SpringApplication.run(JavaProyectoApplication.class, args);
	}

	//@Override
	public void run(String...Args) throws Exception{
		
		try {
			Cliente cliente1 = new Cliente("Damian", "Jacques", "20-27790057-3", "Ambrosetti 2517");
			Cliente cliente2 = new Cliente("Noelia", "Martorello", "27-27484740-4", "Cristiania 1588");
			Cliente cliente3 = new Cliente("Julieta", "Jacques", "27-49157641-2", "J.B.justo 642");
			
			Producto cuaderno = new Producto("Cuaderno Exito");
			Producto repuesto = new Producto("Repuesto Rivadavia");
			Producto boligrafo = new Producto("Boligrafo Bic");
			
			Venta venta1 = new Venta("venta1", cliente1);
			Venta venta2 = new Venta("venta2", cliente2);
			Venta venta3 = new Venta("venta3", cliente3);
			
						
			dao.createCliente(cliente1);
			dao.createCliente(cliente2);
			dao.createCliente(cliente3);
			dao.createProducto(cuaderno);
			dao.createProducto(repuesto);
			dao.createProducto(boligrafo);
			dao.createVenta(venta1);
			dao.createVenta(venta2);
			dao.createVenta(venta3);
			
		} catch( Exception e) {
			e.printStackTrace(System.err);
		}
	
}
}