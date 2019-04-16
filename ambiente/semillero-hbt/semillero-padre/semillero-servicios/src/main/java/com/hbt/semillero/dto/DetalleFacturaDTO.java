package com.hbt.semillero.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hbt.semillero.entidades.Bebida;
import com.hbt.semillero.entidades.Factura;
import com.hbt.semillero.entidades.Plato;

/**
 * 
 * @author felip
 *
 */
public class DetalleFacturaDTO implements Serializable {
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * atributos de la clase
	 */
	private String idDetalle;	
	
	private Factura idFactura;
	
	private Plato idPlato;
	
	private Bebida idBebida;
	
	private float precioUnitario;

	/**
	 * Metodos get y set para cada atributo
	 * @return
	 */
	public String getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(String idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Factura getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Factura idFactura) {
		this.idFactura = idFactura;
	}

	public Plato getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(Plato idPlato) {
		this.idPlato = idPlato;
	}

	public Bebida getIdBebida() {
		return idBebida;
	}

	public void setIdBebida(Bebida idBebida) {
		this.idBebida = idBebida;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	

}
