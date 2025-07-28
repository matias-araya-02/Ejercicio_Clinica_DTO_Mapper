package com.example.clinica.service;

import com.example.clinica.dto.PacienteCreateDTO;
import com.example.clinica.dto.PacienteResponseDTO;
import com.example.clinica.entities.Paciente;
import com.example.clinica.exception.ResourceNotFoundException;
import com.example.clinica.mapper.PacienteMapper;
import com.example.clinica.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PacienteService {

    private final PacienteRepository repository;
    private final PacienteMapper mapper;

    public PacienteService(PacienteRepository repository, PacienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PacienteResponseDTO crearPaciente(PacienteCreateDTO dto) {
        // Validar que no exista DNI duplicado
        if (repository.existsByDni(dto.getDni())) {
            throw new IllegalArgumentException("Ya existe un paciente con el DNI: " + dto.getDni());
        }

        // Validar que no exista email duplicado
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Ya existe un paciente con el email: " + dto.getEmail());
        }

        Paciente paciente = mapper.toEntity(dto);
        Paciente pacienteGuardado = repository.save(paciente);
        return mapper.toResponseDTO(pacienteGuardado);
    }

    @Transactional(readOnly = true)
    public List<PacienteResponseDTO> listarPacientes() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PacienteResponseDTO obtenerPacientePorId(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con ID: " + id));
        return mapper.toResponseDTO(paciente);
    }

    // Método interno para usar en otros servicios
    public Paciente obtenerEntidadPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con ID: " + id));
    }
}
