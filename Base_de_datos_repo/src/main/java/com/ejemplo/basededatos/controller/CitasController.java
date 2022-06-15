package com.ejemplo.basededatos.controller;


import com.ejemplo.basededatos.dto.CitasDTO;
import com.ejemplo.basededatos.model.CitasEntity;
import com.ejemplo.basededatos.services.ICitasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
@RequestMapping("/citas")
public class CitasController {

    private ICitasService iCitasService;

    public CitasController(ICitasService iCitasService) {
        this.iCitasService = iCitasService;
    }

    @PostMapping
    public ResponseEntity crearCita(@RequestBody CitasEntity citasEntity) {
        return iCitasService.crearCita(citasEntity);
    }

    //1
     @GetMapping("/medico/native-query")
    public ResponseEntity getMedicoQuery(@PathParam("medico")String medico){
        return iCitasService.getMedicoQuery(medico);
     }

     @GetMapping("/medico/jpql")
    public ResponseEntity getMedicoJPQL(@PathParam("medico")String medico){
        return iCitasService.getMedicoJPQL(medico);
     }

     @GetMapping("/medico/jpa")
    public ResponseEntity getMedicoJpaRepository(@PathParam("medico") String medico){
        return iCitasService.getMedicoJpaRepository(medico);
     }

     //2

    @GetMapping("/id-paciente/query")
    public ResponseEntity getIdPacienteNativeQuery(@PathParam("idPaciente")Integer idPaciente){
        return iCitasService.getIdPacienteQuery(idPaciente);
    }

    @GetMapping("/id-paciente/jpql")
    public ResponseEntity getIdPacienteForJPQL(@PathParam("idPaciente")Integer idPaciente){
        return iCitasService.getIdPacienteJPQL(idPaciente);
    }

    @GetMapping("/id-paciente/jpa")
    public ResponseEntity getIdPacienteJPA(@PathParam("idPaciente")Integer idPaciente){
        return iCitasService.getIdPacienteJpaRepository(idPaciente);
    }

    //3
    @GetMapping("/eps/query")
    public ResponseEntity getEpsNativeQuery(@PathParam("eps")String eps){
        return iCitasService.getEpsQuery(eps);
    }

    @GetMapping("/eps/jpql")
    public ResponseEntity getEpsForJPQL(@PathParam("eps")String eps){
        return iCitasService.getEpsJPQL(eps);
    }

    @GetMapping("/eps/jpa")
    public ResponseEntity getEpsJPA(@PathParam("eps")String eps){
        return iCitasService.getEpsJpaRepository(eps);
    }

     @PutMapping("/{id}")
    public ResponseEntity putCita(@PathVariable Long id, @RequestBody CitasDTO citasDTO){
        return iCitasService.actualizarCita(id, citasDTO);
     }

}
