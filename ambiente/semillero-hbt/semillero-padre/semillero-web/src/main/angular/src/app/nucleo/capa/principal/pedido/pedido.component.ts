import { Component, OnInit } from '@angular/core';
import { PlatoDTO } from '../modelos/PlatoDTO';
import { ConsultarPlatosService } from 'src/app/nucleo/servicios/servicios-plato/consultar.plato.service';
import { ConsultarBebidaService } from 'src/app/nucleo/servicios/servicios-bebida/consultar.bebida.service';
import { BebidaDTO } from '../modelos/BebidaDTO';
import { ClienteDTO } from '../modelos/ClienteDTO';
import { ConsultarClientesService } from 'src/app/nucleo/servicios/servicios-clientes/consultar.cliente.service';
import { DetalleDTO } from '../modelos/DetalleDTO';
import { ConsultarDetalleService } from 'src/app/nucleo/servicios/servicios-factura/consultar.detalle.service';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent implements OnInit {

  /**
   * listas donde se guardara las consultas
   */
  public listaPlatosDTO: PlatoDTO[];
  public listaBebidasDTO: BebidaDTO[];
  public listarClientesDTO: ClienteDTO[];
  public listarDetalleDTO: DetalleDTO[];

  /**
   * variables donde se guardara los valores del ngModel
   */
  public precio:number;
  public idFactura:number;
  public idBebida:number;
  public idPlato:number;
  public precioPlato;
  public precioBebida;
  


/**
 * Constructor donde se llaman los servicios
 * @param platoService 
 * @param bebidaService 
 * @param clienteService 
 * @param detalleService 
 */
  constructor(private platoService : ConsultarPlatosService, private bebidaService: ConsultarBebidaService,
    private clienteService : ConsultarClientesService, private detalleService : ConsultarDetalleService ) { }

    /**
     * ngOnInit
     */
  ngOnInit() {
    this.listarPlatos();
    this.listarBebidas();
    this.listarClientes();
    this.precio = 0;
    this.idFactura = 0;
    this.idBebida =0;
    this.idPlato = 0;
    this.precioPlato = 0;
    this.precioBebida = 0;
    
  }

  /**
   * Funcion para consultar los platos
   */
  public listarPlatos(){
    this.listaPlatosDTO = [];
    console.log("lista1", this.listaPlatosDTO)
    this.platoService.consultarPlatos().subscribe(
      plato => {
        this.listaPlatosDTO = plato;
      },
      error => {
       console.log(error);
     } 
     
    );
    
    console.log("resultado del servicio", this.listaPlatosDTO);
  }

  /**
   * funcion para consultar las bebidas
   */
  public listarBebidas(){
    this.listaBebidasDTO = [];
    console.log("lista1", this.listaBebidasDTO)
    this.bebidaService.consultarBebidas().subscribe(
      bebida => {
        this.listaBebidasDTO = bebida;
      },
      error => {
       console.log(error);
     } 
     
    );
    
    console.log("resultado del servicio", this.listaBebidasDTO);
  }

  /**
   * funcion para consultar los clientes
   */
  public listarClientes(){
    this.listarClientesDTO = [];
    this.clienteService.consultarClientes().subscribe(
      cliente => {
        this.listarClientesDTO = cliente;
      },
      error => {
       console.log(error);
     } 
     
    ); 
   }

   /**
    * funcion para consultar el detalle de una factura
    */
   public consultarDetalleFactura(){
    this.listarDetalleDTO = [];
    this.detalleService.consultarDetalleFactura(this.idFactura).subscribe(
      detalle => {
        this.listarDetalleDTO = detalle;
      },
      error => {
       console.log(error);
     } 
     
    ); 
   }

   /**
    * funcion para crear el detalle de uan factura
    */
   public crearDetalle(){

    var detalle:DetalleDTO ={
      idFactura:this.idFactura,
       idPlato: this.idPlato, 
       idBebida: this.idBebida, 
       precioUnitario: this.precioUnitario(this.precioBebida, this.precioPlato), 
      };
  
   this.detalleService.crearDetalle(detalle);
   }

   /**
    * funcion para sumar el valor del plato y bebida para ingresar como precio unitario en el detalle
    * @param bebida 
    * @param plato 
    */
   public precioUnitario(bebida:number, plato:number){
      var precio = bebida + plato;
      return precio;
   }

}
