package com.example.clinica.dto;

import lombok.Data;

@Data
public class PacienteResponseDTO {
    private Long id;
    private String nombreCompleto;
    private String email;
    private String dni;
}
