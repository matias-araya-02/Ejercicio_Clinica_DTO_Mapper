package com.example.clinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TurnoCreateDTO {
    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fecha;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "El médico es obligatorio")
    private String medico;

    @NotNull(message = "El ID del paciente es obligatorio")
    private Long idPaciente;
}
