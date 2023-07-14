package com.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prueba.entidad.Producto;
import com.prueba.repositorio.ProductoRepositorio;
@SpringBootApplication
public class CrudPruebaSebastianArenasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudPruebaSebastianArenasApplication.class, args);
	}

	@Autowired
	private ProductoRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {

/*
		Producto producto1=new Producto("Doritos", "0001",2, 10, "Snacks", 10, "27-06-2023");

		repositorio.save(producto1);

		Producto producto2=new Producto("Tenis", "0002",100, 40, "calzado", 20, "27-06-2023");
		repositorio.save(producto2);

		Producto producto3=new Producto("Play 4", "0003",500, 410, "videojuegos", 10, "14-07-2023");
		repositorio.save(producto3);

		Producto producto4=new Producto("colgate", "0004",2, 12, "aseo", 20, "27-06-2023");
		repositorio.save(producto4);*/
	}
}
