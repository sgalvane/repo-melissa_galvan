package com.proyecto.proveedores.services;

import com.proyecto.proveedores.dto.ProductsDTO;
import org.springframework.http.ResponseEntity;

public interface IProductosService {

    ResponseEntity saveProduct(ProductsDTO productsDTO);

    ResponseEntity updateProduct(Long id, ProductsDTO productsDTO);

    ResponseEntity deleteProduct(Long id);

    ResponseEntity getAllProducts();

    ResponseEntity getIdProvider(Long idProveedor);

    ResponseEntity getProductName(String nombre);

    ResponseEntity getStock(Integer stock);

    ResponseEntity getProductPrice(Double precio);

}
