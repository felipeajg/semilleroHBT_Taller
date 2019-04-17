package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * 
 * @author felip
 *
 */
public class BebidaDTO implements Serializable

{
	/**
	 * serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * atributos
	 */
    private Long idBebida;
	
	private String nombre;
	
	private float precio;

	/**
	 * metodos get y set
	 * @return
	 */
	public Long getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(Long idBebida) {
		this.idBebida = idBebida;
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
	
	


}
