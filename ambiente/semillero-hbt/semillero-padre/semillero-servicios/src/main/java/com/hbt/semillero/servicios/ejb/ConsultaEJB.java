package com.hbt.semillero.servicios.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.BebidaDTO;
import com.hbt.semillero.dto.ClienteDTO;
import com.hbt.semillero.dto.DetalleFacturaDTO;
import com.hbt.semillero.dto.FacturaDTO;
import com.hbt.semillero.dto.PlatoDTO;
import com.hbt.semillero.entidades.Bebida;
import com.hbt.semillero.entidades.Cliente;
import com.hbt.semillero.entidades.DetalleFactura;
import com.hbt.semillero.entidades.Factura;
import com.hbt.semillero.entidades.Plato;
import com.hbt.semillero.servicios.interfaces.IConsultasEjbLocal;

/**
 * @author felipe Jamioy EJB de consultas
 */
@Stateless
public class ConsultaEJB implements IConsultasEjbLocal {

	/************************ Plato ****************************/

	/**
	 * Persistencia
	 */
	@PersistenceContext
	private EntityManager entity;

	/**
	 * Metodo que consulta los platos de la bd
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PlatoDTO> consultarPlatos() {
		List<Plato> platos = entity.createQuery("Select pl from Plato pl ").getResultList();
		List<PlatoDTO> platosRetorno = new ArrayList<>();
		for (Plato plato : platos) {
			PlatoDTO platoDTO = new PlatoDTO();
			platoDTO.setNombre(plato.getNombre());
			platoDTO.setPrecio(plato.getPrecio());
			platoDTO.setDescripcion(plato.getDescripcion());
			platosRetorno.add(platoDTO);
		}
		return platosRetorno;

	}

	/**
	 * Metodo utilizado para crear platos, este es un post
	 * 
	 * @param plato
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearPlato(PlatoDTO platoDTO) {

		Plato plato = new Plato();
		plato.setNombre(platoDTO.getNombre());
		plato.setPrecio(platoDTO.getPrecio());
		plato.setDescripcion(platoDTO.getDescripcion());

		entity.persist(plato);

	}

	/**
	 * metoddo creado para editar un plato
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarPlato(PlatoDTO platoDTO) {

		Plato plato = entity.find(Plato.class, platoDTO.getIdPlato());
		plato.setNombre(platoDTO.getNombre());
		plato.setPrecio(platoDTO.getPrecio());
		plato.setDescripcion(platoDTO.getDescripcion());

		entity.persist(plato);

	}

	/********************** CLIENTE ****************************/

	/**
	 * Metodo utilizado para editar un cliente
	 * 
	 * @param cliente
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarCliente(ClienteDTO clienteDTO) {

		Cliente cliente = entity.find(Cliente.class, clienteDTO.getIdCliente());
		cliente.setNombre(clienteDTO.getNombre());
		entity.merge(cliente);

	}

	/**
	 * Metodo utilizado para crear un cliente
	 * 
	 * @param cliente
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setNombre(clienteDTO.getNombre());
		entity.persist(cliente);
	}

	/**
	 * Metodo utilizado para consultar los clientes
	 * 
	 * @return clientes
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ClienteDTO> consultarClientes() {
		List<Cliente> clientes = entity.createQuery("Select cl from Cliente cl ").getResultList();
		List<ClienteDTO> clientesRetorno = new ArrayList<>();
		for (Cliente cliente : clientes) {
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setNombre(cliente.getNombre());
			clientesRetorno.add(clienteDTO);
		}
		return clientesRetorno;

	}

	/**************************** FACTURA ****************************/

	/**
	 * Metodo utilizado para crear una factura
	 * 
	 * @param factura
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearFactura(FacturaDTO facturaDTO) {
		Factura factura = new Factura();
		factura.setClienteId(facturaDTO.getClienteId());
		factura.setIva(facturaDTO.getIva());
		factura.setTotal(facturaDTO.getTotal());
		entity.persist(factura);
	}

	/************************** DETALLE FACTURA ******************************/

	/**
	 * Metodo utilizado para crear el detalle de la factura
	 * 
	 * @param detalle
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearDetalles(DetalleFacturaDTO detalleDTO) {
		
		if(detalleDTO.getIdBebida()!=null || detalleDTO.getIdPlato()!=null) {
			DetalleFactura detalle = new DetalleFactura();
			detalle.setIdDetalle(detalleDTO.getIdDetalle());
			detalle.setIdPlato(detalleDTO.getIdPlato());
			detalle.setIdBebida(detalleDTO.getIdBebida());
			detalle.setPrecioUnitario(detalleDTO.getPrecioUnitario());
			entity.persist(detalle);
		}
				

	}
	
	/**
	 * Metodo utilizado para consultar los detalles de una factura	
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<DetalleFacturaDTO> consultarDetallePorFactura(Long idFactura) {
		
		StringBuilder consulta = new StringBuilder("Select dt FROM Factura_detalle dt WHERE 1=1 ");
		
		Map<String, Object> parametros = new HashMap<>();
		
		if (idFactura != 0) {
			
			consulta.append(" and dt.idFactura =:idFactura");
			parametros.put("idFactura", idFactura);				
		}
		
		Query query = entity.createQuery(consulta.toString());

		for (Entry<String, Object> entry : parametros.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<DetalleFactura> detalles = query.getResultList();
		List<DetalleFacturaDTO> detallesRetorno = new ArrayList<>();
		for (DetalleFactura detalle : detalles) {
			DetalleFacturaDTO detalleDTO = new DetalleFacturaDTO();
			detalleDTO.setIdFactura(detalle.getIdFactura());
			detalleDTO.setIdPlato(detalle.getIdPlato());
			detalleDTO.setIdBebida(detalle.getIdBebida());
			detalleDTO.setPrecioUnitario(detalle.getPrecioUnitario());

			detallesRetorno.add(detalleDTO);
		}
		return detallesRetorno;
	}
	
	/*****************************BEBIDAS***********************************/
	
	/**
	 * Metodo que consulta los platos de la bd
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<BebidaDTO> consultarBebidas() {
		List<Bebida> bebidas = entity.createQuery("Select b from Bebida b ").getResultList();
		List<BebidaDTO> bebidasRetorno = new ArrayList<>();
		for (Bebida bebida : bebidas) {
			BebidaDTO bebidaDTO = new BebidaDTO();
			bebidaDTO.setNombre(bebida.getNombre());
			bebidaDTO.setPrecio(bebida.getPrecio());
			bebidasRetorno.add(bebidaDTO);
		}
		return bebidasRetorno;

	}
	
	/**
	 * firma del metodo crear pedido
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void crarPedido() {
		
	}

}
