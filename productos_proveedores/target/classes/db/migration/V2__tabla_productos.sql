use ventas;
create table productos (
   id_producto INT NOT NULL auto_increment,
   id_proveedor INT NOT NULL,
   nombre VARCHAR(50) NOT NULL,
   precio DOUBLE NOT NULL,
   stock INT,
   fecha_creacion DATE,
   fecha_eliminacion DATE,
   primary key (id_producto)
);