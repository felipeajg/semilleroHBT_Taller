package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hbt.semillero.entidades.Cliente;

/**
 * Clase copia de la entidad Factura
 * @author felip
 *
 */
public class FacturaDTO implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributos de la clase
	 */
	private Long idFactura;	
	
	private Cliente clienteId;
	
	private float iva;
	
	private float total;

	/**
	 * Metodos get y set para cada atributo de la clase
	 * @return
	 */
	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
