use ventas;
create table proveedores
(
    id_proveedor INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    fecha_creacion DATE,
    fecha_eliminacion DATE,
    primary key (id_proveedor)
);
