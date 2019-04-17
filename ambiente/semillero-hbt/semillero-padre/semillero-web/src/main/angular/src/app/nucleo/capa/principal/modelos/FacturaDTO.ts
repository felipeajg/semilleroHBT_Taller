/**
 * modelo factura
 */
export interface FacturaDTO {
    idFactura: number;
    idCliente: number;
    iva: number;  
    total:number;  
  }