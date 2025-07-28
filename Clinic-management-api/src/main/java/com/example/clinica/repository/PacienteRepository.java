package com.example.clinica.repository;

import com.example.clinica.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByDni(String dni);
    Optional<Paciente> findByEmail(String email);
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
}
