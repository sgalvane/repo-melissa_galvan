package com.ejemplo.basededatos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitasDTO {

    private String medico;

    private String eps;

    private Integer idPaciente;

}
