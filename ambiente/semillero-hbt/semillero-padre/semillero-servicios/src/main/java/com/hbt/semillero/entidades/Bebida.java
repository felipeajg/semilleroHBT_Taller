package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad bebida
 * @author felipe jamioy
 *
 */
@Entity
@Table(name = "BEBIDA")
public class Bebida implements Serializable {
	
	/**
	 * Atributos de la entidad bebida
	 */
	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "BEBIDA_ID")
	private Long idBebida;
	
	@Column(name = "BEBIDA_NOMBRE")
	private String nombre;
	
	@Column(name = "PRECIO")
	private float precio;

	/**
	 * Metodos get y set de la bebida
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
