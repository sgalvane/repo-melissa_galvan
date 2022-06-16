package com.ejemplo.basededatos.repository;

import com.ejemplo.basededatos.model.CitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CitasRepository  extends JpaRepository<CitasEntity,Long> {


    @Query(value = "SELECT c.* FROM citas c WHERE c.medico = :medico", nativeQuery = true)
    List<CitasEntity> buscarPorMedico(String medico);

    @Query("SELECT c FROM CitasEntity c WHERE c.medico = :medico")
    List<CitasEntity> buscarPorMedicoJPQL(String medico);

    List<CitasEntity> findByMedico(String medico);


    @Query(value = "SELECT p.* FROM citas p WHERE p.idPaciente = :idPaciente", nativeQuery = true)
    List<CitasEntity> buscarPorIdPaciente(Integer idPaciente);

    @Query(value = "SELECT p FROM CitasEntity p WHERE p.idPaciente = :idPaciente")
    List<CitasEntity> buscarPorIdPacienteJPQL(Integer idPaciente);

    List<CitasEntity> findByIdPaciente(Integer idPaciente);



    @Query(value = "SELECT e.* FROM citas e WHERE e.eps = :eps", nativeQuery = true)
    List<CitasEntity> buscarPorEps(String eps);

    @Query(value = "SELECT e FROM CitasEntity e WHERE e.eps = :eps")
    List<CitasEntity> buscarPorEpsJPQL(String eps);

    List<CitasEntity> findByEps(String eps);

}
