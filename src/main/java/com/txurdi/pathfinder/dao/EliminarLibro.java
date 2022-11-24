package com.txurdi.pathfinder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.pathfinder.model.Personaje;

/**
 * Ejemplo para eliminar un Libro
 * @author Ander Uraga Real
 *
 */
public class EliminarLibro {

	public static void main(String[] args) {


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();		
		
		em.getTransaction().begin();		
		
		// obtener Libro por Id
		Personaje l = em.find(Personaje.class,1);
		
		//eliminar
		if ( l != null ) {
			em.remove(l);
		}else {
			System.out.println("No se puede elimiar un libro que no existe");
		}
		
		
		em.getTransaction().commit();		
		em.close();
		
	}

}
