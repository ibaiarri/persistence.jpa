package com.txurdi.pathfinder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // @Entity define que la entidad es persistible contra la base de datos

@NamedQuery(query = "SELECT per FROM Personaje per WHERE per.id_personaje = :id_personaje", name = "find Personaje by id")

public class Personaje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_personaje;

	@NotEmpty
	@Size(min = 2, max = 20, message = "El nombre del personaje debe  estar entre 2 y 20 caracteres")
	private String nombre;

	@NotEmpty
	private String raza;

	@NotNull
	private int nivel;

	@NotEmpty
	private String clase;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	@Valid // SIRVE PARA VALIDAR EN CASCADA CUENTA SE VALIDA ESTE OBJETO
	private Usuario user;

	public Personaje() {
		super();
		this.id_personaje = 0;
		this.nombre = "";
		this.raza = "";
		this.nivel = 0;
		this.clase = "";
		this.user = new Usuario();
	}

	public Personaje(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Personaje(String nombre, String raza, int nivel, String clase, Usuario user) {
		this();
		this.nombre = nombre;
		this.raza = raza;
		this.nivel = nivel;
		this.clase= clase;
		this.user = user;
	}

	public int getId_personaje() {
		return id_personaje;
	}

	public void setId_personaje(int id_personaje) {
		this.id_personaje = id_personaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Personaje [id_personaje=" + id_personaje + ", nombre=" + nombre + ", raza=" + raza + ", nivel=" + nivel
				+ ", clase=" + clase + ", user=" + user + "]";
	}

}
