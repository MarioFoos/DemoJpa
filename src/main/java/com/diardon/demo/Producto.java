package com.diardon.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre", nullable = false, length = 200)
	private String nombre;
	@Column(name = "precio", nullable = false, precision = 10)
	private Double precio;

	// Constructor sin argumentos (requerido por JPA)
	public Producto()
	{
	}
	// Constructor con parámetros
	public Producto(String nombre, Double precio)
	{
		this.nombre = nombre;
		this.precio = precio;
	}
	// Getters y setters
	public Long getId()
	{
		return id;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public Double getPrecio()
	{
		return precio;
	}
	public void setPrecio(Double precio)
	{
		this.precio = precio;
	}
}
