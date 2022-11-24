package com.txurdi.pathfinder.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.txurdi.pathfinder.model.Personaje;

/**
 * Una anotación @NamedQuery se define como una consulta con una cadena de
 * consulta predefinida que es inmutable. En contraste con consultas dinámicas,
 * llamadas consultas pueden mejorar la organización del código al separar las
 * cadenas de consulta JPQL de POJO. También pasa los parámetros de consulta en
 * lugar de incrustar los literales dinámicamente en la cadena de consulta y por
 * lo tanto produce más eficientes consultas.
 * 
 * @author ander
 * @see https://www.tutorialspoint.com/es/jpa/jpa_jpql.htm
 *
 */
public class BuscarLibroConNamedQuery {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();

		Query query = em.createNamedQuery("find libro by id");
		query.setParameter("id", 2);

		List<Personaje> libros = query.getResultList();

		for (Personaje libro : libros) {
			System.out.print(libro);
		}

		em.close();

	}

}
