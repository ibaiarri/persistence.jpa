package com.txurdi.pathfinder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.pathfinder.model.Personaje;

/**
 * Ejemplo para modificar un Libro
 * @author Ander Uraga Real
 *
 */
public class ModificarLibro {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		
		em.getTransaction().begin();		
		
		// obtener Libro por Id
		Personaje l = em.find(Personaje.class,1);
		
		// Update
		l.setNombre( "** " + l.getNombre() + " **");
		em.merge(l);
		
		
		em.getTransaction().commit();		
		em.close();
		
	}

}
