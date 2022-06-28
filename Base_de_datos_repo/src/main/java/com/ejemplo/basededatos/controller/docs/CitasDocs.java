package com.ejemplo.basededatos.controller.docs;

import com.ejemplo.basededatos.dto.CitasDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;

@Tag(name = "aplicacion de asignacion de citas")
public interface CitasDocs {

    @Operation(summary = "Servicio para busqueda por nombre del medico")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna las citas de determinado medico",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getMedicoJpaRepository(@PathParam("nombreMedico") String nombreMedico);


    @Operation(summary = "Servicio para busqueda por nombre del medico")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna las citas de determinado medico",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getMedicoQuery(String nombreMedico);


    @Operation(summary = "Servicio para busqueda por Id del paciente")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna las citas segun Id de paciente",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getIdPacienteJPA(@PathParam("idPaciente") Integer idPaciente);


    @Operation(summary = "Servicio para busqueda por nombre de EPS")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "retorna las citas segun la EPS",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity getEpsJPA(@PathParam("eps") String eps);


    @Operation(summary = "Servicio para actualizar cita")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "actualiza los datos ingresados",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity updateCita(@PathVariable Long id, @RequestBody CitasDTO citasDTO);


    @Operation(summary = "Servicio para eliminar cita")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "elimina los datos",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity deleteHard(@PathVariable Long id);


    @Operation(summary = "Servicio para eliminar cita con registro de fecha")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "elimina los datos y registra la fecha de eliminacion",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity deleteLogic(@PathVariable Long id);


    @Operation(summary = "Servicio para guardar datos de cita")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "guarda los datos de la cita",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE
                                    )
                            }
                    )
            }
    )
    ResponseEntity saveCita(@RequestBody CitasDTO citasDTO);

}
