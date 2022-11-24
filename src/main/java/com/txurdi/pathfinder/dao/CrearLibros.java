package com.txurdi.pathfinder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.pathfinder.model.Personaje;



/**
 * Ejemplo para crear Libros mediante el EntityManager
 * @author ander
 *
 */
public class CrearLibros {

	public static void main(String[] args) throws Exception {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		Personaje libro = new Personaje("Dime quien soy");
		Personaje libro2 = new Personaje("El libro de la selva");
		Personaje libro3 = new Personaje("Papillom");
		
		em.persist(libro);
		em.persist(libro2);
		
		/*
		if ( true ) {
			throw new Exception("Excepcion lanzada a proposito, No deberia guardarse ningun Libro en la bbdd");
		}
		*/	
		
		em.persist(libro3);
		
		
		em.getTransaction().commit();
		
		em.close();
		
		

	}

}
