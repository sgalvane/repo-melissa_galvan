package com.ejemplo.basededatos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ejemplo.basededatos.sample.CitasEntitySample;
import com.ejemplo.basededatos.services.ICitasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(CitasController.class)
class CitasControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ICitasService iCitasService;


    @Test
    void getNombreMedicoQueryOK() throws Exception {
        when(iCitasService.getMedicoQuery(any())).thenReturn(CitasEntitySample.getCitaEntity());

        mvc.perform(get("/api/citas/medico/native-query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.medico").value("gonzales"));

        verify(iCitasService).getMedicoQuery(any());
    }

    @Test
    void getNombreMedicoJPQLOK() throws Exception{
        when(iCitasService.getMedicoJPQL(any())).thenReturn(CitasEntitySample.getCitaEntity());

        mvc.perform(get("/api/citas/medico/jpql")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.medico").value("gonzales"));

        verify(iCitasService).getMedicoJPQL(any());
    }

    @Test
    void getNombreMedicoJPAOK() throws Exception {
        when(iCitasService.getMedicoJpaRepository(any())).thenReturn(CitasEntitySample.getCitaEntity());

        mvc.perform(get("/api/citas/medico/jpa")
                     .contentType(MediaType.APPLICATION_JSON)
                     .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.medico").value("gonzales"));

        verify(iCitasService).getMedicoJpaRepository(any());
    }

    @Test
    void getIdPacienteNativeQueryOK() throws Exception {
        when(iCitasService.getIdPacienteQuery(any())).thenReturn(CitasEntitySample.getCitaEntity());
        mvc.perform(get("/api/citas/id-paciente/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.idPaciente").value("1"));

        verify(iCitasService).getIdPacienteQuery(any());
    }

    @Test
    void getIdPacienteForJPQLOK() throws Exception {
        when(iCitasService.getIdPacienteJPQL(any())).thenReturn(CitasEntitySample.getCitaEntity());
        mvc.perform(get("/api/citas/id-paciente/jpql")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.idPaciente").value("1"));

        verify(iCitasService).getIdPacienteJPQL(any());
    }

    @Test
    void getIdPacienteJPAOK() throws Exception {
        when(iCitasService.getIdPacienteJpaRepository(any())).thenReturn(CitasEntitySample.getCitaEntity());
        mvc.perform(get("/api/citas/id-paciente/jpa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.idPaciente").value("1"));

        verify(iCitasService).getIdPacienteJpaRepository(any());
    }

    @Test
    void getEpsNativeQueryOK() throws Exception {
        when(iCitasService.getEpsQuery(any())).thenReturn(CitasEntitySample.getCitaEntity());
        mvc.perform(get("/api/citas/eps/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.eps").value("saludtotal"));

        verify(iCitasService).getEpsQuery(any());
    }


    @Test
    void getEpsForJPQLOK() throws Exception {
        when(iCitasService.getEpsJPQL(any())).thenReturn(CitasEntitySample.getCitaEntity());
        mvc.perform(get("/api/citas/eps/jpql")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.eps").value("saludtotal"));

        verify(iCitasService).getEpsJPQL(any());
    }


    @Test
    void getEpsOK() throws Exception {
        when(iCitasService.getEpsJpaRepository(any())).thenReturn(CitasEntitySample.getCitaEntity());
        mvc.perform(get("/api/citas/eps/jpa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.eps").value("saludtotal"));

        verify(iCitasService).getEpsJpaRepository(any());
    }


    @Test
    void saveCitaOK() throws Exception{
        when(iCitasService.saveCita(any())).thenReturn(CitasEntitySample.getCitaEntity());

        mvc.perform(post("/api/citas/")
                        .content(objectToJson(CitasEntitySample.getRequestCitaEntity()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.idPaciente").value(1))
                .andExpect(jsonPath("$.medico").value("gonzales"))
                .andExpect(jsonPath("$.eps").value("saludtotal"));

       verify(iCitasService).saveCita(any());
    }

    @Test
    void actualizarCitaOK() throws Exception{
        when(iCitasService.actualizarCita(anyLong(),any())).thenReturn(CitasEntitySample.getCitaEntity());

        mvc.perform(put("/api/citas/1")
                       .content(objectToJson(CitasEntitySample.getRequestCitaEntity()))
                       .contentType(MediaType.APPLICATION_JSON)
                       .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.idPaciente").value(1))
                .andExpect(jsonPath("$.medico").value("gonzales"))
                .andExpect(jsonPath("$.eps").value("saludtotal"));

        verify(iCitasService).actualizarCita(anyLong(),any());
    }


    @Test
    void deleteHardOK() throws Exception{
        when(iCitasService.deleteHard(anyLong())).thenReturn(CitasEntitySample.getCitaEntity());

        mvc.perform(delete("/api/citas/delete/1")
                     .content(objectToJson(CitasEntitySample.getRequestCitaEntity()))
                     .contentType(MediaType.APPLICATION_JSON)
                     .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));

        verify(iCitasService).deleteHard(anyLong());
    }

    @Test
    void deleteLogicOK() throws Exception {
        when(iCitasService.deleteLogic(anyLong())).thenReturn(CitasEntitySample.getCitaEntity());

        mvc.perform(delete("/api/citas/logic/1")
                        .content(objectToJson(CitasEntitySample.getRequestCitaEntity()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value(1));

        verify(iCitasService).deleteLogic(anyLong());
    }


    public static String objectToJson(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

}