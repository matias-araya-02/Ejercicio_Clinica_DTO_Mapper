package com.example.clinica.mapper;

import com.example.clinica.dto.PacienteCreateDTO;
import com.example.clinica.dto.PacienteResponseDTO;
import com.example.clinica.entities.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public Paciente toEntity(PacienteCreateDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNombre(dto.getNombre());
        paciente.setApellido(dto.getApellido());
        paciente.setDni(dto.getDni());
        paciente.setEmail(dto.getEmail());
        return paciente;
    }

    public PacienteResponseDTO toResponseDTO(Paciente paciente) {
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(paciente.getId());
        dto.setNombreCompleto(paciente.getNombre() + " " + paciente.getApellido());
        dto.setEmail(paciente.getEmail());
        dto.setDni(paciente.getDni());
        return dto;
    }
}
