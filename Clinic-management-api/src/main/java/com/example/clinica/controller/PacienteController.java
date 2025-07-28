package com.example.clinica.controller;

import com.example.clinica.dto.PacienteCreateDTO;
import com.example.clinica.dto.PacienteResponseDTO;
import com.example.clinica.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    /**
     * Crear un nuevo paciente
     * POST /api/pacientes
     */
    @PostMapping
    public ResponseEntity<PacienteResponseDTO> crearPaciente(@Valid @RequestBody PacienteCreateDTO dto) {
        PacienteResponseDTO pacienteCreado = service.crearPaciente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteCreado);
    }

    /**
     * Listar todos los pacientes
     * GET /api/pacientes
     */
    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listarPacientes() {
        List<PacienteResponseDTO> pacientes = service.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    /**
     * Obtener un paciente por ID
     * GET /api/pacientes/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> obtenerPaciente(@PathVariable Long id) {
        PacienteResponseDTO paciente = service.obtenerPacientePorId(id);
        return ResponseEntity.ok(paciente);
    }
}
