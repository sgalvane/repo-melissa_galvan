package com.ejemplo.basededatos.controller.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "aplicacion de lista de empleados")
public interface EmployeeDocs {


    @Operation(summary = "Servicio para listar empleados")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna listado de empleados",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEmployees();


    @Operation(summary = "Servicio para listar empleados por Id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna listado de empleados segun Id",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEmployeeId(@PathVariable Long id);


    @Operation(summary = "Servicio para listar empleados con edad mayor a 30")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna listado de empleados segun edad",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEmployeeAge();


    @Operation(summary = "Servicio para listar empleados con salario mayor a 100000")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna listado de empleados segun salario",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEmployeeSalary();

}
