package com.ejemplo.basededatos.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "citas")
public class CitasEntity implements Serializable {

    @Id
    @Column(name = "id_cita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idPaciente;

    private String medico;

    private String eps;

    @Column(name = "fecha_cita")
    private Date fechaCita;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_eliminacion")
    private Date fechaEliminacion;

    public CitasEntity(){

    }

    public CitasEntity(Long id, Integer idPaciente, String medico, String eps, Date fechaCita, Date fechaCreacion, Date fechaEliminacion) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.medico = medico;
        this.eps = eps;
        this.fechaCita = fechaCita;
        this.fechaCreacion = fechaCreacion;
        this.fechaEliminacion = fechaEliminacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }
}
