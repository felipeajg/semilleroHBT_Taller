package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Entidad factura detalle
 * @author felip
 *
 */
@Entity
@Table(name = "FACTURA_DETALLE")
public class DetalleFactura implements Serializable {
	
	/**
	 * Atributos de la entidad
	 */
	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "DETALLE_ID")
	private String idDetalle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FACTURA_ID")
	private Factura idFactura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLATO_ID")
	private Plato idPlato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BEBIDA_ID")
	private Bebida idBebida;
	
	@Column(name = "PRECIO_UNITARIO")
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
