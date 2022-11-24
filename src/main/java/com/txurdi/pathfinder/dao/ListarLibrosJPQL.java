package com.txurdi.pathfinder.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.txurdi.pathfinder.model.Personaje;



/**
 * Ejemplo para crear Libros mediante el Java Persistence Query Language
 * Sintaxis JPQL es muy similar a la sintaxis de SQL. 
 * Tener SQL como sintaxis es una ventaja porque SQL es simple y siendo ampliamente utilizado.
 * SQL trabaja directamente contra la base de datos relacional tablas, registros y campos, mientras que JPQL trabaja con Java clases e instancias.
 * 
 * @author ander
 * @see https://www.arquitecturajava.com/jpa-query-language-objetos-vs-tablas/
 *
 */
public class ListarLibrosJPQL {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");
		EntityManager em = emf.createEntityManager();
	
	
		// no hace falta transacciones
		//em.getTransaction().begin();
		
		final String JPQL = "SELECT l FROM Libro l";
		/*
		 * Cuando la tabla en la base de datos se denomina Libros .
		 * Si que es correcta ya que la consulta de JPA nunca hace referencia a una tabla de la base de datos 
		 * sino a la Entidad del dominio que en nuestro caso de denomina “Libro” por lo tanto es lo que tenemos que poner. 
		 * Eso sí el framework se encargará del mapeo de forma automática ya que la tabla en la base de datos se denomina Libros . 
		 *	Este mapeo lo realiza la anotación @Table de la entidad
		 * 
		 * */
		
		
		ArrayList<Personaje> libros = (ArrayList<Personaje>) em.createQuery(JPQL).getResultList();		
		System.out.println(libros);
		
		em.close();
			

	}

}
