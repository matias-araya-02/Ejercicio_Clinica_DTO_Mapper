package com.example.clinica.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TurnoResponseDTO {
    private Long id;
    private LocalDateTime fecha;
    private String especialidad;
    private String medico;
    private String pacienteNombre;
    private Long pacienteId;
}
