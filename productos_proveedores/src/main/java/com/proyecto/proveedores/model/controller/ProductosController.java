package com.proyecto.proveedores.model.controller;

import com.proyecto.proveedores.dto.ProductsDTO;
import com.proyecto.proveedores.model.controller.docs.ProductosDocs;
import com.proyecto.proveedores.services.IProductosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/productos")
public class ProductosController implements ProductosDocs {

    private final IProductosService iProductosService;

    public ProductosController(IProductosService iProductosService) {
        this.iProductosService = iProductosService;
    }

    @PostMapping
    public ResponseEntity saveProduct(ProductsDTO productsDTO) {
        return iProductosService.saveProduct(productsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(Long id, ProductsDTO productsDTO) {
        return iProductosService.updateProduct(id, productsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(Long id) {
        return iProductosService.deleteProduct(id);
    }

    @GetMapping("/listarProductos")
    public ResponseEntity listarProductos() {
        return iProductosService.getAllProducts();
    }

    @GetMapping("/id-proveedor/{idProveedor}")
    public ResponseEntity getIdProvider(Long idProveedor){
        return iProductosService.getIdProvider(idProveedor);
    }

    @GetMapping("/nombreProducto/{nombre}")
    public ResponseEntity getProductName(String nombre){
        return iProductosService.getProductName(nombre);
    }

    @GetMapping("/numeroStock/{stock}")
    public ResponseEntity getStock(Integer stock) {
        return iProductosService.getStock(stock);
    }

    @GetMapping("/precioProducto/{precio}")
    public ResponseEntity getProductPrice(Double precio) {
        return iProductosService.getProductPrice(precio);
    }

}
