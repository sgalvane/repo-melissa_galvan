package com.ejemplo.basededatos.services;
import com.ejemplo.basededatos.dto.CitasDTO;
import com.ejemplo.basededatos.model.CitasEntity;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface ICitasService {

    ResponseEntity crearCita(CitasEntity citasEntity);

    ResponseEntity getMedicoQuery(String medico);
    ResponseEntity getMedicoJPQL(String medico);
    ResponseEntity getMedicoJpaRepository(String medico);

    ResponseEntity getIdPacienteQuery(Integer idPaciente);
    ResponseEntity getIdPacienteJPQL(Integer idPaciente);
    ResponseEntity getIdPacienteJpaRepository(Integer idPaciente);

    ResponseEntity getEpsQuery(String eps);
    ResponseEntity getEpsJPQL(String eps);
    ResponseEntity getEpsJpaRepository(String eps);

    ResponseEntity actualizarCita(Long id, CitasDTO citasDTO);


    ResponseEntity deleteHard(Long id);

    ResponseEntity deleteLogic(Long id);

}
