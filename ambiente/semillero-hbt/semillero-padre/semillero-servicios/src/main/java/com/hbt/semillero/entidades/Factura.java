package com.hbt.semillero.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad factura
 * @author felip
 *
 */
@Entity
@Table(name = "FACTURA")
public class Factura {
	
	/**
	 * atributos de la entidad
	 */
	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "FACTURA_ID")
	private Long idFactura;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente clienteId;
	
	@Column(name = "IVA")
	private float iva;
	
	@Column(name = "TOTAL")
	private float total;

	/**
	 * Metodos get y set para cada atributo
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
	
	

}
