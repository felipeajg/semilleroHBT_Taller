package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad Plato
 * @author felipe
 *
 */
@Entity
@Table(name = "PLATO")
public class Plato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * atributos de la entidad
	 */
	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "PLATO_ID")
	private Long idPlato;
	
	@Column(name = "PLATO_NOMBRE")
	private String nombre;
	
	@Column(name = "PRECIO")
	private float precio;
	
	@Column(name = "PLATO_DESCRIPCION")
	private String descripcion;

	/**
	 * Metodos get y set de cada atributo
	 * @return
	 */
	public Long getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(Long idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	


}
