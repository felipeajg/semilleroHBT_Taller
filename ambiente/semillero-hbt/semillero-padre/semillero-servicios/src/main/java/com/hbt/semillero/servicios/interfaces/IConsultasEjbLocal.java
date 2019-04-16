package com.hbt.semillero.servicios.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.dto.DetalleFacturaDTO;
import com.hbt.semillero.dto.FacturaDTO;
import com.hbt.semillero.dto.PlatoDTO;
import com.hbt.semillero.entidades.DetalleFactura;

/**
 * 
 * @author felipe jamioy Interfaz local
 *
 */
@Local
public interface IConsultasEjbLocal {

	/**
	 * Metodo de la interfaz para consultar los platos
	 * @return
	 */
	public List<PlatoDTO> consultarPlatos();

	/**
	 * Metodo de la interfaz para crear los platos
	 * @return
	 */
	public void crearPlato(PlatoDTO platoDTO);

	/**
	 * Metodo de la interfaz para editar los platos
	 * @return
	 */
	public void editarPlato(PlatoDTO platoDTO);

	/**
	 * Metodo de la interfaz para editar los clientes
	 * @return
	 */
	public void editarCliente(ClienteDTO clienteDTO);

	/**
	 * Metodo de la interfaz para crear clientes
	 * @return
	 */
	public void crearCliente(ClienteDTO clienteDTO);

	/**
	 * Metodo de la interfaz para consultar los clientes
	 * @return
	 */
	public List<ClienteDTO> consultarClientes();

	/**
	 * Metodo de la interfaz para crear las facturas
	 * @return
	 */
	public void crearFactura(FacturaDTO facturaDTO);

	/**
	 * Metodo para crear Detalles 
	 * @param detalleDTO
	 * @param fecha
	 */
	public void crearDetalles(DetalleFacturaDTO detalleDTO);
	
	/**
	 * Metodo utilizado para consultar los detaller que tiene una factura
	 * @param idFactura
	 * @return
	 */
	public List<DetalleFacturaDTO> consultarDetallePorFactura(Long idFactura);

}
