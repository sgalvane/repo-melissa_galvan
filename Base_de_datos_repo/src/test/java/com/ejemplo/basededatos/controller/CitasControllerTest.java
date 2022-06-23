package com.ejemplo.basededatos.controller;

import com.ejemplo.basededatos.sample.CitasEntitySample;
import com.ejemplo.basededatos.services.ICitasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(CitasController.class)
class SearchControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ICitasService iCitasService;

    @Test
    void getNombreMedicoOK() throws Exception {
        when(iCitasService.getMedicoJpaRepository(anyString())).thenReturn(CitasEntitySample.getNombreMedico());

        mvc.perform(get("/api/citas/medico/jpa")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").value("gonzales"));

        verify(iCitasService).getMedicoJpaRepository(anyString()));
    }


}
