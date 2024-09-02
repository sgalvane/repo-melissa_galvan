package com.proyecto.proveedores.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "productos")
public class ProductoEntity implements Serializable {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_proveedor")
    private Long idProveedor;

    private String nombre;

    private Double precio;

    private Integer stock;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_eliminacion")
    private Date fechaEliminacion;
}
