package com.proyecto.proveedores.services.impl;

import com.proyecto.proveedores.model.ProductoEntity;
import com.proyecto.proveedores.repository.ProductosRepository;
import com.proyecto.proveedores.sample.ProductoEntitySample;
import com.proyecto.proveedores.services.IProductosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class ProductosServiceImplTest {

    @MockBean
    ProductosRepository productosRepository;

    @Autowired
    IProductosService iProductosService;


    @Test
    void saveProductOK() {
        when(productosRepository.save(any())).thenReturn(ProductoEntitySample.getRequestProductoEntity());
        var responseEntity = iProductosService.saveProduct(ProductoEntitySample.getRequestProductoDTO());
        ProductoEntity producto = (ProductoEntity) responseEntity.getBody();

        verify(productosRepository, times(1)).save(any());
        assertNotNull(producto);
        assertEquals("Cereales", producto.getNombre());
        assertEquals(1, producto.getIdProveedor());
        assertEquals(6.9, producto.getPrecio());
        assertEquals(45, producto.getStock());
    }


    @Test
    void updateProductOK() {
        when(productosRepository.findById(any())).thenReturn(Optional.ofNullable(ProductoEntitySample.getRequestProductoEntity()));
        Optional<ProductoEntity> producto = productosRepository.findById(1L);

        verify(productosRepository, times(1)).findById(any());
        assertNotNull(producto);
        assertEquals(true, producto.isPresent());
    }


    @Test
    void deleteProductOK() {
        when(productosRepository.findByIdAndFechaEliminacionIsNull(anyLong())).thenReturn(ProductoEntitySample.getRequestProductoEntity());
        var responseEntity = iProductosService.deleteProduct(1L);
        String producto = (String) responseEntity.getBody();

        verify(productosRepository, times(1)).findByIdAndFechaEliminacionIsNull(anyLong());
        assertNotNull(producto);
    }


    @Test
    void getAllProductsOK() {
        when(productosRepository.findAll()).thenReturn(ProductoEntitySample.getProductoEntityList());
        var responseEntity = iProductosService.getAllProducts();
        List<ProductoEntity> list = (List<ProductoEntity>) responseEntity.getBody();

        verify(productosRepository, times(1)).findAll();
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals("Cereales", list.get(0).getNombre());
        assertEquals(1L, list.get(0).getIdProveedor());
        assertEquals(6.9, list.get(0).getPrecio());
    }


    @Test
    void getIdProviderOK() {
        when(productosRepository.findByIdProveedor(anyLong())).thenReturn(ProductoEntitySample.getProductoEntityList());
        var responseEntity = iProductosService.getIdProvider(1L);
        List<ProductoEntity> list = (List<ProductoEntity>) responseEntity.getBody();

        verify(productosRepository, times(1)).findByIdProveedor(anyLong());
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals(1L, list.get(0).getIdProveedor());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }


    @Test
    void getProductNameOK() {
        when(productosRepository.findByNombre(anyString())).thenReturn(ProductoEntitySample.getProductoEntityList());
        var responseEntity = iProductosService.getProductName("Cereales");
        List<ProductoEntity> list = (List<ProductoEntity>) responseEntity.getBody();

        verify(productosRepository, times(1)).findByNombre(anyString());
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals("Cereales", list.get(0).getNombre());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }


    @Test
    void getStockOK() {
        when(productosRepository.findByStock(anyInt())).thenReturn(ProductoEntitySample.getProductoEntityList());
        var responseEntity = iProductosService.getStock(45);
        List<ProductoEntity> list = (List<ProductoEntity>) responseEntity.getBody();

        verify(productosRepository, times(1)).findByStock(anyInt());
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals(45, list.get(0).getStock());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }


    @Test
    void getProductPriceOK() {
        when(productosRepository.findByPrecio(anyDouble())).thenReturn(ProductoEntitySample.getProductoEntityList());
        var responseEntity = iProductosService.getProductPrice(6.9);
        List<ProductoEntity> list = (List<ProductoEntity>) responseEntity.getBody();

        verify(productosRepository, times(1)).findByPrecio(anyDouble());
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals(6.9, list.get(0).getPrecio());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }
}