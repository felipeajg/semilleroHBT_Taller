CREATE TABLE PLATO
( plato_id number(10) NOT NULL,
  plato_nombre varchar2(50) NOT NULL,
  precio number(10) NOT NULL,
  plato_descripcion varchar2(100) NOT NULL,
  CONSTRAINT plato_pk PRIMARY KEY (plato_id)
);

CREATE TABLE BEBIDA
( bebida_id number(10) NOT NULL,
  bebida_nombre varchar2(50) NOT NULL,
  precio number(10) NOT NULL,
  CONSTRAINT bebida_pk PRIMARY KEY (bebida_id)
);

CREATE TABLE CLIENTE
( cliente_id number(10) NOT NULL,
  cliente_nombre varchar2(50) NOT NULL,
  CONSTRAINT cliente_pk PRIMARY KEY (cliente_id)
);

CREATE TABLE FACTURA
( factura_id number(10) NOT NULL,
  cliente_id number(10) NOT NULL,
  iva number(10) NOT NULL,
  total number(10) NOT NULL,
  CONSTRAINT factura_pk PRIMARY KEY (factura_id),
  CONSTRAINT fk_cliente
    FOREIGN KEY (cliente_id)
    REFERENCES CLIENTE(cliente_id)
);

CREATE TABLE FACTURA_DETALLE
( detalle_id varchar2(50) NOT NULL,
  factura_id number(10) NOT NULL,
  plato_id number(10),
  bebida_id number(10),
  precio_unitario number(20),
  CONSTRAINT detalle_pk PRIMARY KEY (detalle_id),
  CONSTRAINT fk_factura_detalle
    FOREIGN KEY (factura_id)
    REFERENCES FACTURA(factura_id),
  CONSTRAINT fk_plato_detalle
    FOREIGN KEY (plato_id)
    REFERENCES PLATO(plato_id),
  CONSTRAINT fk_bebida_detalle
    FOREIGN KEY (bebida_id)
    REFERENCES BEBIDA(bebida_id)
);
