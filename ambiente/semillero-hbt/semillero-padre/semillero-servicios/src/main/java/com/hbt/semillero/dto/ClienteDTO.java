package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * copia de la entidad cliente
 * @author felip
 *
 */
public class ClienteDTO implements Serializable{
	
	/**
	 * serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * atributos de la entidad cliente
	 */
	private Long idCliente;
	
	private String nombre;

	/**
	 * Metodos get y set para cada atributo
	 * @return
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
