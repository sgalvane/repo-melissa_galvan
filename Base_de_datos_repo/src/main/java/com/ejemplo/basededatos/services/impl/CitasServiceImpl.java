package com.ejemplo.basededatos.services.impl;

import com.ejemplo.basededatos.constants.AppConstants;
import com.ejemplo.basededatos.dto.CitasDTO;
import com.ejemplo.basededatos.model.CitasEntity;
import com.ejemplo.basededatos.repository.CitasRepository;
import com.ejemplo.basededatos.services.ICitasService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CitasServiceImpl implements ICitasService {

    private CitasRepository citasRepository;

    public CitasServiceImpl(CitasRepository citasRepository) {
        this.citasRepository = citasRepository;
    }


    @Override
    public ResponseEntity getMedicoQuery(String medico) {
        return ResponseEntity.ok(citasRepository.buscarPorMedico(medico));
    }

    @Override
    public ResponseEntity getMedicoJPQL(String medico) {
        return ResponseEntity.ok(citasRepository.buscarPorMedicoJPQL(medico));
    }

    @Override
    public ResponseEntity getMedicoJpaRepository(String medico) {
        return ResponseEntity.ok(citasRepository.findByMedico(medico));
    }


    @Override
    public ResponseEntity getIdPacienteQuery(Integer idPaciente) {
        return ResponseEntity.ok(citasRepository.buscarPorIdPaciente(idPaciente));
    }

    @Override
    public ResponseEntity getIdPacienteJPQL(Integer idPaciente) {
        return ResponseEntity.ok(citasRepository.buscarPorIdPacienteJPQL(idPaciente));
    }

    @Override
    public ResponseEntity getIdPacienteJpaRepository(Integer idPaciente) {
        return ResponseEntity.ok(citasRepository.findByIdPaciente(idPaciente));
    }


    @Override
    public ResponseEntity getEpsQuery(String eps) {
        return ResponseEntity.ok(citasRepository.buscarPorEps(eps));
    }

    @Override
    public ResponseEntity getEpsJPQL(String eps) {
        return ResponseEntity.ok(citasRepository.buscarPorEpsJPQL(eps));
    }

    @Override
    public ResponseEntity getEpsJpaRepository(String eps) {
        return ResponseEntity.ok(citasRepository.findByEps(eps));
    }

    @Override
    public ResponseEntity actualizarCita(Long id, CitasDTO citasDTO) {
        String validar;
        var citaOptional = citasRepository.findById(id);
        if (citaOptional.isPresent()) {
            var cita =CitasEntity
                    .builder()
                    .medico(citasDTO.getMedico())
                    .eps(citasDTO.getEps())
                    .build();
            var citaActualizar=citasRepository.save(cita);
            validar = AppConstants.ACTUALIZACION_EXITOSA;
        }else {
           validar = AppConstants.NO_EXISTE;
        }return ResponseEntity.ok(validar);

    }

    @Override
    public ResponseEntity deleteHard(Long id) {
        String validar;
        var citaOption = citasRepository.findById(id);
        if (citaOption.isPresent()) {
            citasRepository.delete(citaOption.get());
            validar = AppConstants.ELIMINACION_EXITOSA;
        }else {
            validar = AppConstants.ELIMINADO;
        }return ResponseEntity.ok(validar);

    }

    @Override
    public ResponseEntity deleteLogic(Long id) {
        String validar;
        validar = AppConstants.ELIMINACION_EXITOSA;
        var cita = citasRepository.findById(id).get();
        cita.setFechaEliminacion(new Date());
        citasRepository.save(cita);
        return ResponseEntity.ok(validar);
    }

    @Override
    public ResponseEntity saveCita(CitasDTO citasDTO) {
       var cita = CitasEntity
               .builder()
               .idPaciente(citasDTO.getIdPaciente())
               .eps(citasDTO.getEps())
               .medico(citasDTO.getMedico())
               .build();
       var citaNueva=citasRepository.save(cita);

       return ResponseEntity.ok(citaNueva);
    }

}