package com.prueba.entidad;

import jakarta.persistence.*;

@Entity
@Table(name="Productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(name="nombre",nullable=false,length=255)
	private String nombre;
	
	@Column(name="referencia",nullable=false,length=255)
	private String referencia;
	
	@Column(name="precio",nullable=false)
	private int precio;
	
	@Column(name="peso",nullable=false)
	private int peso;
	
	@Column(name="categoria",nullable=false,length=255)
	private String categoria;
	
	@Column(name="stock",nullable=false)
	private int stock;
	
	@Column(name="fecha",nullable=false,length=255)
	private String fecha;
	
	 public Producto() {
		 
	 }

	public Producto(String nombre, String referencia, int precio, int peso, String categoria, int stock,
			String fecha) {
		super();
		//this.id = id;
		this.nombre = nombre;
		this.referencia = referencia;
		this.precio = precio;
		this.peso = peso;
		this.categoria = categoria;
		this.stock = stock;
		this.fecha = fecha;
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

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", referencia=" + referencia + ", precio=" + precio
				+ ", peso=" + peso + ", categoria=" + categoria + ", stock=" + stock + ", fecha=" + fecha + "]";
	}
	
	
}
