package com.proyecto.proveedores.services.impl;

import com.proyecto.proveedores.constants.AppConstants;
import com.proyecto.proveedores.dto.ProductsDTO;
import com.proyecto.proveedores.model.ProductoEntity;
import com.proyecto.proveedores.repository.ProductosRepository;
import com.proyecto.proveedores.services.IProductosService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Objects;

@Service
public class ProductosServiceImpl implements IProductosService {

    private ProductosRepository productosRepository;

    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public ResponseEntity saveProduct(ProductsDTO productsDTO) {
        var product = ProductoEntity
                .builder()
                .idProveedor(productsDTO.getIdProveedor())
                .nombre(productsDTO.getNombre())
                .precio(productsDTO.getPrecio())
                .stock(productsDTO.getStock())
                .build();
        var newProduct = productosRepository.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @Override
    public ResponseEntity updateProduct(Long id, ProductsDTO productsDTO) {
        String validate;
        var productOptional = productosRepository.findById(id);
        if (productOptional.isPresent()){
            ProductoEntity productoEntity = productOptional.get();
            productoEntity.setIdProveedor(productsDTO.getIdProveedor());
            productoEntity.setNombre(productsDTO.getNombre());
            productoEntity.setPrecio(productsDTO.getPrecio());
            productoEntity.setStock(productsDTO.getStock());
            productosRepository.save(productoEntity);
            validate = AppConstants.ACTUALIZACION_EXITOSA;
        } else {
            validate = AppConstants.NO_EXISTE;
        } return ResponseEntity.ok(validate);
    }

    @Override
    public ResponseEntity deleteProduct(Long id) {
        String validate;
        ProductoEntity productoEntity = productosRepository.findByIdAndFechaEliminacionIsNull(id);
        if (Objects.isNull(productoEntity)) {
            validate = AppConstants.HA_SIDO_ELIMINADO;
        }else {
            productoEntity.setFechaEliminacion(new Date());
            productosRepository.save(productoEntity);
            validate = AppConstants.ELIMINACION_EXITOSA;
        }
            return ResponseEntity.ok(validate);
    }

    @Override
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(productosRepository.findAll());
    }

    @Override
    public ResponseEntity getIdProvider(Long idProveedor) {
        return ResponseEntity.ok(productosRepository.findByIdProveedor(idProveedor));
    }

    @Override
    public ResponseEntity getProductName(String nombre) {
        return ResponseEntity.ok(productosRepository.findByNombre(nombre));
    }

    @Override
    public ResponseEntity getStock(Integer stock) {
        return ResponseEntity.ok(productosRepository.findByStock(stock));
    }

    @Override
    public ResponseEntity getProductPrice(Double precio) {
        return ResponseEntity.ok(productosRepository.findByPrecio(precio));
    }

}
