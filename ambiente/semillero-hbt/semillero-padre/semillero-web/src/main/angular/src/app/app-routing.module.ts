import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PedidoComponent } from './nucleo/capa/principal/pedido/pedido.component';
import { CapaComponent } from './nucleo/capa/capa.component';

const routes: Routes = [
	{   path: 'crear-pedido',
	    component: PedidoComponent
		},
		
		{   path: 'capa',
	    component: CapaComponent
  	},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
