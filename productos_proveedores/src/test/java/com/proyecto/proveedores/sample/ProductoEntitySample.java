package com.proyecto.proveedores.sample;

import com.proyecto.proveedores.dto.ProductsDTO;
import com.proyecto.proveedores.model.ProductoEntity;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProductoEntitySample {

    public static ResponseEntity getProductoEntity() {
        ProductoEntity producto = new ProductoEntity(1L, 1L, "Cereales", 6.900, 45, new Date(), new Date());
        return ResponseEntity.ok(producto);
    }


    public static ProductoEntity getRequestProductoEntity() {
        ProductoEntity producto = ProductoEntity.builder()
                .id(1L)
                .idProveedor(1L)
                .nombre("Cereales")
                .precio(6.900)
                .stock(45)
                .fechaCreacion(new Date())
                .build();
        return producto;
    }

    public static ProductsDTO getRequestProductoDTO() {
        ProductsDTO productoDTO = new ProductsDTO();
        productoDTO.setIdProveedor(1L);
        productoDTO.setNombre("Cereales");
        productoDTO.setPrecio(6.900);
        productoDTO.setStock(45);
        return productoDTO;
    }

    public static ResponseEntity getBodyEntityList() {
        List<ProductoEntity> listaProducto = new ArrayList<>();
        ProductoEntity producto = ProductoEntity.builder()
                .idProveedor(1L)
                .nombre("Cereales")
                .precio(6.900)
                .stock(45)
                .fechaCreacion(new Date())
                .build();
        listaProducto.add(producto);
        listaProducto.add(producto);
        listaProducto.add(producto);
        return ResponseEntity.ok(listaProducto);
    }


    public static List<ProductoEntity> getProductoEntityList() {
        return (List<ProductoEntity>) getBodyEntityList().getBody();
    }
}