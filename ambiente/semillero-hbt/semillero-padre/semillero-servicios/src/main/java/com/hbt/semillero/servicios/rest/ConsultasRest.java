package com.hbt.semillero.servicios.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.BebidaDTO;
import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.dto.DetalleFacturaDTO;
import com.hbt.semillero.dto.FacturaDTO;
import com.hbt.semillero.dto.PlatoDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal;

/**
 * Clase para hacer las consultas de rest
 * @author felipe jamioy
 *
 */
@Path("/ConsultasRest")
public class ConsultasRest {
	
	/**
	 * Instancia de la interfaz IconsultasEjbLocal
	 */
	@EJB
	private IConsultasEjbLocal consultaEJB;	
	
	/**
	 * Metodo get para consultar los platos
	 * @return lista de platos
	 */
	@GET
	@Path("/consultarPlatos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlatoDTO> consultarPlatos() {
		return consultaEJB.consultarPlatos();
	}
	
	/**
	 * Metodo para crear los platos
	 * @param platoDTO
	 * @return mensaje
	 */
	@POST
	@Path("/crearPlatos")
	@Produces(MediaType.APPLICATION_JSON)
	 public ResultadoDTO crearPlato(PlatoDTO platoDTO) {
		 
		ResultadoDTO retorno = new ResultadoDTO(true, "se creo con exito");
		try {		
			
			consultaEJB.crearPlato(platoDTO);

		}catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeEjecucion("no se puede ingresar el plato");
		}
		
		return retorno;
		 
		 
	 }
	
	/**
	 * Metodo para editar los platos
	 * @param platoDTO
	 * @return mensaje
	 */
	@POST
	@Path("/editarPlatos")
	@Produces(MediaType.APPLICATION_JSON)
	 public ResultadoDTO editarPlato(PlatoDTO platoDTO){
		
		ResultadoDTO retorno = new ResultadoDTO(true, "se edito con exito");		
		
		try {		
			
			consultaEJB.editarPlato(platoDTO);

		}catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeEjecucion("no se puede editar el plato");
		}
		
		return retorno;
		
		
	}

	
	/***********************************************************/
	
	/**
	 * Metodo para consultar los clientes 
	 * @return lista de clientes
	 */
	@GET
	@Path("/consultarClientes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteDTO> consultarClientes() {
		return consultaEJB.consultarClientes();
	}
	
	/**
	 * Metodo para crear clientes
	 * @param personaDTO
	 * @return mensaje
	 */
	@POST
	@Path("/crearClientes")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearCliente(ClienteDTO personaDTO){
		
		ResultadoDTO retorno = new ResultadoDTO(true,"Exitoso");		
		
		try {		
			
			consultaEJB.crearCliente(personaDTO);

		}catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeEjecucion("no se puede ingresar la persona");
		}
		
		return retorno;		
	}
	
	/**
	 * Metodo para editar clientes
	 * @param clienteDTO
	 * @return mensaje
	 */
	@POST
	@Path("/editarClientes")
	@Produces(MediaType.APPLICATION_JSON)
	 public ResultadoDTO editarCliente(ClienteDTO clienteDTO){
		
		ResultadoDTO retorno = new ResultadoDTO(true, "editado con exito");		
		
		try {		
			
			consultaEJB.editarCliente(clienteDTO);

		}catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeEjecucion("no se puede editar el plato");
		}
		
		return retorno;
		
		
	}
	
	/******************************FACTURA***********************************************/
	
	/**
	 * Metodo para crear facturas
	 * @param facturaDTO
	 * @return mensaje
	 */
	@POST
	@Path("/crearFactura")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO CrearFactura(FacturaDTO facturaDTO) {

		ResultadoDTO retorno = new ResultadoDTO(true, "Exitoso");

		try {

			consultaEJB.crearFactura(facturaDTO);

		} catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeEjecucion("no se puede ingresar la persona");
		}

		return retorno;

	}
	
	/*****************************DETALLE FACTURA***************************************/
	
	/**
	 * Metodo para crear un detalle
	 * @param detalleDTO
	 * @return mensaje
	 */
	@POST
	@Path("/crearDetalles")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO CrearDetalle(DetalleFacturaDTO detalleDTO) {

		ResultadoDTO retorno = new ResultadoDTO(true, "Exitoso");

		try {

			consultaEJB.crearDetalles(detalleDTO);;

		} catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensajeEjecucion("no se puede ingresar la persona");
		}

		return retorno;

	}
	
	/**
	 * Metodo para consultar los detalles de una factura
	 * @param idFactura
	 * @return
	 */
	@GET
	@Path("/consultarDetalleDeFactura")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DetalleFacturaDTO> consultarDetallePorFactura(Long idFactura) {
		return consultaEJB.consultarDetallePorFactura(idFactura);
	}
	
	/************************************************************/
	
	/**
	 * Metodo get para consultar los platos
	 * @return lista de platos
	 */
	@GET
	@Path("/consultarBebidas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BebidaDTO> consultarBebidas() {
		return consultaEJB.consultarBebidas();
	}
	
	@POST
	@Path("/crearPedido")
	@Produces(MediaType.APPLICATION_JSON)
	public void crarPedido() {
		
	}
	
}
