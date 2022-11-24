package com.txurdi.pathfinder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.pathfinder.model.Usuario;

public class EjemploEditorial {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario e1 = new Usuario("Barco de Vapor");
		Usuario e2 = new Usuario("Alfaguarra");
		
		em.persist(e1);
		em.persist(e2);
		
		
		em.getTransaction().commit();
		em.close();
		
	}

}
