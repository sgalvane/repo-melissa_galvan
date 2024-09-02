package com.proyecto.proveedores.model.controller.docs;

import com.proyecto.proveedores.dto.ProductsDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Aplicacion de ventas")
public interface ProductosDocs {

    @Operation(summary = "Servicio para guardar producto")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "guarda los datos del producto",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity saveProduct(@RequestBody ProductsDTO productsDTO);


    @Operation(summary = "Servicio para actualizar datos del producto")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "guarda los datos del producto",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity updateProduct(@PathVariable Long id, @RequestBody ProductsDTO productsDTO);


    @Operation(summary = "Servicio para eliminar el producto")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "elimina los datos del producto",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity deleteProduct(@PathVariable Long id);



    @Operation(summary = "Servicio para buscar producto segun id de proveedor")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna los datos del producto",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getIdProvider(@PathVariable Long idProveedor);



    @Operation(summary = "Servicio para buscar producto segun nombre del producto")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna los datos del producto",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getProductName(@PathVariable String nombre);



    @Operation(summary = "Servicio para buscar producto segun stock")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna los datos del producto",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getStock(@PathVariable Integer stock);



    @Operation(summary = "Servicio para buscar producto segun precio")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna los datos del producto",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getProductPrice(@PathVariable Double precio);



    @Operation(summary = "Servicio para listar todos los productos")
    @ApiResponses(
            value =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna la lista de productos",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity listarProductos();
}
