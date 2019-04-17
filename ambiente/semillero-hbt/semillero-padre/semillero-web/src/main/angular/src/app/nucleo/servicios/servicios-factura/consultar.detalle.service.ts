
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { ClienteDTO } from '../../capa/principal/modelos/ClienteDTO';
import { AbstractService } from '../template.service';
import { DetalleDTO } from '../../capa/principal/modelos/DetalleDTO';

@Injectable({
    providedIn: 'root'
  })
  /**
   * Servicio para consultar clientes
   */
  export class ConsultarDetalleService extends AbstractService {

    /**
     * constructor con el injector
     */
    constructor(injector: Injector) {
      super(injector);
    }
    /**
     * Servicio para consultar los clientes
     * 
     */
    public consultarDetalleFactura(idFactura:number) : Observable<DetalleDTO[]> { 
          return this.get<DetalleDTO[]>("/semillero-servicios", "/ConsultasRest/consultarDetalleDeFactura",
          {
            "idFactura":""+idFactura,
        } );     
      }

        /**
     * Servicio para crear un detalle
     * @param vehiculoDTO 
     */
    public crearDetalle(detalleDTO:DetalleDTO) { 
      console.log("entro al servicio")
        return this.post<DetalleDTO>("/semillero-servicios", "/ConsultasRest/crearDetalles", detalleDTO);  
    }

}