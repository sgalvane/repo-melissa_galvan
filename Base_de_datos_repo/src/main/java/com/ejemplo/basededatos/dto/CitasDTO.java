package com.ejemplo.basededatos.dto;

public class CitasDTO {

    private String medico;

    private String eps;


    public CitasDTO(String medico, String eps) {
        this.medico = medico;
        this.eps = eps;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}
