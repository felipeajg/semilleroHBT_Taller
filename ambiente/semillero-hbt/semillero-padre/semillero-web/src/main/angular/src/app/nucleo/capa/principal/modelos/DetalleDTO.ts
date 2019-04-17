/**
 * modelo detalle
 */
export interface DetalleDTO {
    idDetalle?: number;
    idFactura: number;
    idPlato: number;
    idBebida: number;  
    precioUnitario:number;  
  }