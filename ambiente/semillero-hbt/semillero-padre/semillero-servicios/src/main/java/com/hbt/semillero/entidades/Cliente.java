package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author felipe jamioy
 *
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
	
	/**
	 * serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos de la entidad cliente
	 */
	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "CLIENTE_ID")
	private Long idCliente;
	
	@Column(name = "CLIENTE_NOMBRE")
	private String nombre;

	/**
	 * Metodos get y set para cada atributo de la entidad
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
