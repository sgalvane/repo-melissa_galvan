package com.ejemplo.basededatos.services.impl;

import com.ejemplo.basededatos.model.CitasEntity;
import com.ejemplo.basededatos.repository.CitasRepository;
import com.ejemplo.basededatos.sample.CitasEntitySample;
import com.ejemplo.basededatos.services.ICitasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class CitasServiceImplTest {

    @MockBean
    CitasRepository citasRepository;

    @Autowired
    ICitasService iCitasService;


    @Test
    void getMedicoQuery() {
        when(citasRepository.buscarPorMedico(anyString())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getMedicoQuery(anyString());
        List<CitasEntity> citasEntityList = (List<CitasEntity>) responseEntity.getBody();
        verify(citasRepository, times(1)).buscarPorMedico(anyString());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals("gonzales",citasEntityList.get(0).getMedico());
    }

    @Test
    void getMedicoJPQL() {
        when(citasRepository.buscarPorMedicoJPQL(anyString())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getMedicoJPQL(anyString());
        List<CitasEntity> citasEntityList = (List<CitasEntity>) responseEntity.getBody();
        verify(citasRepository, times(1)).buscarPorMedicoJPQL(anyString());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals("gonzales",citasEntityList.get(0).getMedico());
    }

    @Test
    void getMedicoJpaRepository() {
        when(citasRepository.findByMedico(anyString())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getMedicoJpaRepository(anyString());
        List<CitasEntity> citasEntityList = (List<CitasEntity>) responseEntity.getBody();
        verify(citasRepository, times(1)).findByMedico(anyString());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals("gonzales",citasEntityList.get(0).getMedico());
    }


    @Test
    void getIdPacienteQuery() {
        when(citasRepository.buscarPorIdPaciente(anyInt())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getIdPacienteQuery(anyInt());
        List<CitasEntity> citasEntityList = (List<CitasEntity>)responseEntity.getBody();
        verify(citasRepository, times(1)).buscarPorIdPaciente(anyInt());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }

    @Test
    void getIdPacienteJPQL() {
        when(citasRepository.buscarPorIdPacienteJPQL(anyInt())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getIdPacienteJPQL(anyInt());
        List<CitasEntity> citasEntityList = (List<CitasEntity>)responseEntity.getBody();
        verify(citasRepository, times(1)).buscarPorIdPacienteJPQL(anyInt());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }

    @Test
    void getIdPacienteJpaRepository() {
        when(citasRepository.findByIdPaciente(anyInt())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getIdPacienteJpaRepository(anyInt());
        List<CitasEntity> citasEntityList = (List<CitasEntity>)responseEntity.getBody();
        verify(citasRepository, times(1)).findByIdPaciente(anyInt());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals(200,responseEntity.getStatusCodeValue());
    }



    @Test
    void getEpsQuery() {
        when(citasRepository.buscarPorEps(anyString())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getEpsQuery(anyString());
        List<CitasEntity> citasEntityList = (List<CitasEntity>)responseEntity.getBody();
        verify(citasRepository, times(1)).buscarPorEps(anyString());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals("saludtotal",citasEntityList.get(0).getEps());
    }

    @Test
    void getEpsJPQL() {
        when(citasRepository.buscarPorEpsJPQL(anyString())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getEpsJPQL(anyString());
        List<CitasEntity> citasEntityList = (List<CitasEntity>)responseEntity.getBody();
        verify(citasRepository, times(1)).buscarPorEpsJPQL(anyString());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals("saludtotal",citasEntityList.get(0).getEps());
    }

    @Test
    void getEpsJpaRepository() {
        when(citasRepository.findByEps(anyString())).thenReturn(CitasEntitySample.getListCitas());
        var responseEntity = iCitasService.getEpsJpaRepository(anyString());
        List<CitasEntity> citasEntityList = (List<CitasEntity>)responseEntity.getBody();
        verify(citasRepository, times(1)).findByEps(anyString());

        assertNotNull(citasEntityList);
        assertEquals(1,citasEntityList.size());
        assertEquals("saludtotal",citasEntityList.get(0).getEps());
    }


    @Test
    void saveCita() {
        when(citasRepository.save(any())).thenReturn(CitasEntitySample.getRequestCitaEntity());
        var responseEntity = iCitasService.saveCita(CitasEntitySample.getRequestCitaDTO());
        CitasEntity citas = (CitasEntity) responseEntity.getBody();

        verify(citasRepository, times(1)).save(any());
        assertNotNull(citas);
        assertEquals("saludtotal",citas.getEps());

    }

}