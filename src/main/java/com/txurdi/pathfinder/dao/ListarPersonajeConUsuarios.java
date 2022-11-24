package com.txurdi.pathfinder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.pathfinder.model.Personaje;
import com.txurdi.pathfinder.model.Usuario;

public class ListarPersonajeConUsuarios {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin();

		Usuario usuario1 = new Usuario("Ramon","castrejo",692716076);		
		Personaje personaje1 = new Personaje("Rosa","humano",1,"gur",usuario1);
		Personaje personaje2 = new Personaje("melano","humano",1,"gur",usuario1);
		
		em.persist(usuario1);
		em.persist(personaje1);
		em.persist(personaje2);
		
		
		em.getTransaction().commit();
		em.close();
	}

}
