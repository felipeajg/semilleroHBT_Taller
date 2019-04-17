
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { AbstractService } from '../template.service';
import { BebidaDTO } from '../../capa/principal/modelos/BebidaDTO';
import { PlatoDTO } from '../../capa/principal/modelos/PlatoDTO';

@Injectable({
    providedIn: 'root'
  })
  /**
   * Servicio para consultar platos
   */
  export class ConsultarPlatosService extends AbstractService {

    /**
     * constructor con el injector
     */
    constructor(injector: Injector) {
      super(injector);
    }
    /**
     * Servicio para consultar una platos
     * 
     */
    public consultarPlatos() : Observable<PlatoDTO[]> { 
          return this.get<PlatoDTO[]>("/semillero-servicios", "/ConsultasRest/consultarPlatos");
      }

}