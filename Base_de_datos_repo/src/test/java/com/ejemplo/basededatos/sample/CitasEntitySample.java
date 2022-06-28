package com.ejemplo.basededatos.sample;

import com.ejemplo.basededatos.dto.CitasDTO;
import com.ejemplo.basededatos.model.CitasEntity;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CitasEntitySample {


    public static ResponseEntity getCitaEntity() {
        CitasEntity citas = new CitasEntity(1L, 1, "gonzales", "saludtotal", new Date(), new Date(), new Date());
        return ResponseEntity.ok(citas);
    }

    public static CitasEntity getRequestCitaEntity() {
        CitasEntity citas = CitasEntity.builder()
                .id(1L)
                .idPaciente(1)
                .medico("gonzales")
                .eps("saludtotal")
                .fechaCita(new Date())
                .build();
        return citas;
    }

    public static CitasDTO getRequestCitaDTO(){
        CitasDTO citas = new CitasDTO();
        citas.setMedico("gonzales");
        citas.setEps("saludtotal");
        return citas;
    }


    public static List<CitasEntity> getListCitas(){
        List<CitasEntity> citasEntityList = new ArrayList<>();
        citasEntityList.add(getRequestCitaEntity());
        return citasEntityList;
    }

}
