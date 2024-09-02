package com.proyecto.proveedores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {

    private Long id;

    private Long idProveedor;

    private String nombre;

    private Double precio;

    private Integer stock;
}
