package com.diardon.demo;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class ProductoService
{
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void ejecutarEjemplo()
	{
		// --- 1. Insertar Productos ---
		Producto p1 = new Producto("Carne", 5500.0);
		Producto p2 = new Producto("Aceite", 1500.0);
		Producto p3 = new Producto("Azucar", 800.0);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		System.out.println("Productos insertados.");

		// --- 2. Leer Productos usando JPQL ---
		// Ejemplo: obtener productos con precio mayor a 30
		String jpqlSelect = "SELECT p FROM Producto p WHERE p.precio > :minPrecio";
		TypedQuery<Producto> query = em.createQuery(jpqlSelect, Producto.class);
		query.setParameter("minPrecio", 1000.0);
		List<Producto> productos = query.getResultList();
		System.out.println("Productos con precio mayor a 1000:");
		for(Producto p : productos)
		{
			System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Precio: " + p.getPrecio());
		}

		// --- 3. Borrar Productos usando JPQL ---
		// Ejemplo: eliminar el producto cuyo nombre es 'Mouse'
		String jpqlDelete = "DELETE FROM Producto p WHERE p.nombre = :nombreProd";
		Query deleteQuery = em.createQuery(jpqlDelete);
		deleteQuery.setParameter("nombreProd", "Aceite");
		int borrados = deleteQuery.executeUpdate();
		System.out.println("Número de productos eliminados: " + borrados);

		// Verificar el borrado listando los productos restantes
		List<Producto> productosRestantes = em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
		System.out.println("Productos restantes:");
		for(Producto p : productosRestantes)
		{
			System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | Precio: " + p.getPrecio());
		}
	}
}
