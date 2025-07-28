package com.example.clinica.service;

import com.example.clinica.dto.TurnoCreateDTO;
import com.example.clinica.dto.TurnoResponseDTO;
import com.example.clinica.entities.Paciente;
import com.example.clinica.entities.Turno;
import com.example.clinica.exception.ResourceNotFoundException;
import com.example.clinica.mapper.TurnoMapper;
import com.example.clinica.repository.TurnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TurnoService {

    private final TurnoRepository repository;
    private final TurnoMapper mapper;
    private final PacienteService pacienteService;

    public TurnoService(TurnoRepository repository, TurnoMapper mapper, PacienteService pacienteService) {
        this.repository = repository;
        this.mapper = mapper;
        this.pacienteService = pacienteService;
    }

    public TurnoResponseDTO crearTurno(TurnoCreateDTO dto) {
        // Obtener el paciente (lanza excepción si no existe)
        Paciente paciente = pacienteService.obtenerEntidadPorId(dto.getIdPaciente());

        // Crear y guardar el turno
        Turno turno = mapper.toEntity(dto, paciente);
        Turno turnoGuardado = repository.save(turno);
        return mapper.toResponseDTO(turnoGuardado);
    }

    @Transactional(readOnly = true)
    public List<TurnoResponseDTO> listarTurnos() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TurnoResponseDTO obtenerTurnoPorId(Long id) {
        Turno turno = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con ID: " + id));
        return mapper.toResponseDTO(turno);
    }

    @Transactional(readOnly = true)
    public List<TurnoResponseDTO> obtenerTurnosPorPaciente(Long pacienteId) {
        // Verificar que el paciente existe
        pacienteService.obtenerEntidadPorId(pacienteId);

        return repository.findByPacienteId(pacienteId).stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TurnoResponseDTO> obtenerTurnosPorEspecialidad(String especialidad) {
        return repository.findByEspecialidad(especialidad).stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
