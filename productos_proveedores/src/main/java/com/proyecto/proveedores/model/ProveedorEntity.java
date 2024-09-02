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
@Builder
@Entity
@Table(name="proveedores")
public class ProveedorEntity implements Serializable {
    @Id
    @Column(name = "id_proveedor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_eliminacion")
    private Date fechaEliminacion;

}
