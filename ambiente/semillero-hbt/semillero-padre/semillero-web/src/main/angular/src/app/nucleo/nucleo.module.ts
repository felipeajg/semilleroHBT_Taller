import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PieDePaginaComponent } from './capa/pie-de-pagina/pieDePagina.component';
import { EncabezadoComponent } from './capa/encabezado/encabezado.component';
import { PrincipalComponent } from './capa/principal/principal.component';
import { CapaComponent } from './capa/capa.component';
import { PedidoComponent } from './capa/principal/pedido/pedido.component';
import { RouterModule } from '@angular/router';

/**
 * modulo nucle donde vamos a tener modularmente nuestas vistas
 */
@NgModule({
  declarations: [PieDePaginaComponent, EncabezadoComponent, PrincipalComponent, CapaComponent, PedidoComponent],
  imports: [
    CommonModule,RouterModule
  ],
  exports: [
  	CapaComponent
  ],
  providers: [
      
  ]
})
export class NucleoModule { }
