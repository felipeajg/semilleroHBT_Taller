
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { AbstractService } from '../template.service';
import { BebidaDTO } from '../../capa/principal/modelos/BebidaDTO';

@Injectable({
    providedIn: 'root'
  })
  /**
   * Servicio para consultar bebidas
   */
  export class ConsultarBebidaService extends AbstractService {

    /**
     * constructor con el injector
     */
    constructor(injector: Injector) {
      super(injector);
    }
    /**
     * Servicio para consultar una bebidas
     * 
     */
    public consultarBebidas() : Observable<BebidaDTO[]> { 
          return this.get<BebidaDTO[]>("/semillero-servicios", "/ConsultasRest/consultarBebidas");
      }

}