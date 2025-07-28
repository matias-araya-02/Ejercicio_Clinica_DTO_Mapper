package com.example.clinica.controller;

import com.example.clinica.dto.TurnoCreateDTO;
import com.example.clinica.dto.TurnoResponseDTO;
import com.example.clinica.service.TurnoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {

    private final TurnoService service;

    public TurnoController(TurnoService service) {
        this.service = service;
    }

    /**
     * Crear un nuevo turno
     * POST /api/turnos
     */
    @PostMapping
    public ResponseEntity<TurnoResponseDTO> crearTurno(@Valid @RequestBody TurnoCreateDTO dto) {
        TurnoResponseDTO turnoCreado = service.crearTurno(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoCreado);
    }

    /**
     * Listar todos los turnos
     * GET /api/turnos
     */
    @GetMapping
    public ResponseEntity<List<TurnoResponseDTO>> listarTurnos() {
        List<TurnoResponseDTO> turnos = service.listarTurnos();
        return ResponseEntity.ok(turnos);
    }

    /**
     * Obtener un turno por ID
     * GET /api/turnos/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<TurnoResponseDTO> obtenerTurno(@PathVariable Long id) {
        TurnoResponseDTO turno = service.obtenerTurnoPorId(id);
        return ResponseEntity.ok(turno);
    }

    /**
     * Obtener turnos por paciente
     * GET /api/turnos/paciente/{pacienteId}
     */
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TurnoResponseDTO>> obtenerTurnosPorPaciente(@PathVariable Long pacienteId) {
        List<TurnoResponseDTO> turnos = service.obtenerTurnosPorPaciente(pacienteId);
        return ResponseEntity.ok(turnos);
    }

    /**
     * Obtener turnos por especialidad
     * GET /api/turnos/especialidad/{especialidad}
     */
    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<List<TurnoResponseDTO>> obtenerTurnosPorEspecialidad(@PathVariable String especialidad) {
        List<TurnoResponseDTO> turnos = service.obtenerTurnosPorEspecialidad(especialidad);
        return ResponseEntity.ok(turnos);
    }
}
