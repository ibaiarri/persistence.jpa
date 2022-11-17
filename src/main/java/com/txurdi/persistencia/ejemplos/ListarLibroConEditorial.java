package com.txurdi.persistencia.ejemplos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.persistencia.model.Editorial;
import com.txurdi.persistencia.model.Libro;

public class ListarLibroConEditorial {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		Editorial e1 = new Editorial("edit");		
		Libro l1 = new Libro("libro de la selva",e1);
		Libro l2= new Libro("libro de la selva 2 ",e1);
		
		em.persist(e1);
		em.persist(l1);
		em.persist(l2);
		
		
		em.getTransaction().commit();
		em.close();
	}

}
