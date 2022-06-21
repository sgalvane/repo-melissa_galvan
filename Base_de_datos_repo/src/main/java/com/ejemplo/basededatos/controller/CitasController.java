package com.ejemplo.basededatos.controller;

import com.ejemplo.basededatos.dto.CitasDTO;
import com.ejemplo.basededatos.services.ICitasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/citas")
public class CitasController {

    private ICitasService iCitasService;

    public CitasController(ICitasService iCitasService) {
        this.iCitasService = iCitasService;
    }

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

     @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteHard(@PathVariable Long id){
        return iCitasService.deleteHard(id);
     }

     @DeleteMapping("/logic/{id}")
    public ResponseEntity deleteLogic(@PathVariable Long id){
        return iCitasService.deleteLogic(id);
     }

     @PostMapping
    public ResponseEntity saveCita(@RequestBody CitasDTO citasDTO){
        return iCitasService.saveCita(citasDTO);
     }

}
