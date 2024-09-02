package com.proyecto.proveedores.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.proveedores.model.controller.ProductosController;
import com.proyecto.proveedores.sample.ProductoEntitySample;
import com.proyecto.proveedores.services.IProductosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductosController.class)
public class ProductosControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    IProductosService iProductosService;


    @Test
    void saveProductOK() throws Exception{
        when(iProductosService.saveProduct(any())).thenReturn(ProductoEntitySample.getProductoEntity());

        mvc.perform(post("/productos")
                    .content(objectToJson(ProductoEntitySample.getRequestProductoDTO()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.idProveedor").value(1L))
                .andExpect(jsonPath("$.nombre").value("Cereales"))
                .andExpect(jsonPath("$.precio").value(6.900))
                .andExpect(jsonPath("$.stock").value(45));

        verify(iProductosService).saveProduct(any());
    }

    @Test
    void updateProductOK() throws Exception{
        when(iProductosService.updateProduct(anyLong(),any())).thenReturn(ProductoEntitySample.getProductoEntity());

        mvc.perform(put("/productos/1")
                    .content(objectToJson(ProductoEntitySample.getRequestProductoEntity()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.idProveedor").value(1L))
                .andExpect(jsonPath("$.nombre").value("Cereales"))
                .andExpect(jsonPath("$.precio").value(6.900));

        verify(iProductosService).updateProduct(anyLong(),any());
    }

    @Test
    void deleteProductOK() throws Exception{
        when(iProductosService.deleteProduct(anyLong())).thenReturn(ProductoEntitySample.getProductoEntity());

        mvc.perform(delete("/productos/delete/1")
                        .content(objectToJson(ProductoEntitySample.getProductoEntity()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1L));

        verify(iProductosService).deleteProduct(anyLong());
    }

    @Test
    void listarProductosOK() throws Exception{
        when(iProductosService.getAllProducts()).thenReturn(ProductoEntitySample.getBodyEntityList());

        mvc.perform(get("/productos/listarProductos")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0].nombre").value("Cereales"))
                .andExpect(jsonPath("$[0].precio").value(6.900))
                .andExpect(jsonPath("$[0].stock").value(45));

        verify(iProductosService).getAllProducts();
    }

    @Test
    void getIdProviderOK() throws Exception{
        when(iProductosService.getIdProvider(anyLong())).thenReturn(ProductoEntitySample.getProductoEntity());
        mvc.perform(get("/productos/id-proveedor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.idProveedor").value("1"));

        verify(iProductosService).getIdProvider(anyLong());
    }

    @Test
    void getProductNameOK() throws Exception{
        when(iProductosService.getProductName(anyString())).thenReturn(ProductoEntitySample.getProductoEntity());
        mvc.perform(get("/productos/nombreProducto/Cereales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.nombre").value("Cereales"));

        verify(iProductosService).getProductName(anyString());
    }


    @Test
    void getStockOK() throws Exception{
        when(iProductosService.getStock(anyInt())).thenReturn(ProductoEntitySample.getProductoEntity());
        mvc.perform(get("/productos/numeroStock/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.stock").value("45"));

        verify(iProductosService).getStock(anyInt());
    }

    @Test
    void getProductPriceOK() throws Exception {
        when(iProductosService.getProductPrice(anyDouble())).thenReturn(ProductoEntitySample.getProductoEntity());
        mvc.perform(get("/productos/precioProducto/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.precio").value("6.9"));

        verify(iProductosService).getProductPrice(anyDouble());
    }

    public static String objectToJson(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
