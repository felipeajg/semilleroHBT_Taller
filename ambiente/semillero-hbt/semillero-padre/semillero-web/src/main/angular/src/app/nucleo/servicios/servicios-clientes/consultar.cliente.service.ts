
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { ClienteDTO } from '../../capa/principal/modelos/ClienteDTO';
import { AbstractService } from '../template.service';

@Injectable({
    providedIn: 'root'
  })
  /**
   * Servicio para consultar clientes
   */
  export class ConsultarClientesService extends AbstractService {

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
    public consultarClientes() : Observable<ClienteDTO[]> { 
          return this.get<ClienteDTO[]>("/semillero-servicios", "/ConsultasRest/consultarClientes");
      }

}