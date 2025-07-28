package com.example.clinica.repository;

import com.example.clinica.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByPacienteId(Long pacienteId);
    List<Turno> findByEspecialidad(String especialidad);
    List<Turno> findByMedico(String medico);

    @Query("SELECT t FROM Turno t WHERE t.fecha BETWEEN :inicio AND :fin")
    List<Turno> findByFechaBetween(@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin);
}
