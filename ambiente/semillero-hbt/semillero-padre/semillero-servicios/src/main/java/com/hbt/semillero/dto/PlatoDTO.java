package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PlatoDTO implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
    
	/**
	 * Atributos de la entidad plato
	 */
	private Long idPlato;

	private String nombre;
	
	private float precio;
	
	private String descripcion;

	/**
	 * Metodos get y set de la entidad para cada atributo
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
