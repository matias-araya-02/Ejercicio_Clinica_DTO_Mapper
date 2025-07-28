package com.example.clinica.mapper;

import com.example.clinica.dto.TurnoCreateDTO;
import com.example.clinica.dto.TurnoResponseDTO;
import com.example.clinica.entities.Paciente;
import com.example.clinica.entities.Turno;
import org.springframework.stereotype.Component;

@Component
public class TurnoMapper {

    public Turno toEntity(TurnoCreateDTO dto, Paciente paciente) {
        Turno turno = new Turno();
        turno.setFecha(dto.getFecha());
        turno.setEspecialidad(dto.getEspecialidad());
        turno.setMedico(dto.getMedico());
        turno.setPaciente(paciente);
        return turno;
    }

    public TurnoResponseDTO toResponseDTO(Turno turno) {
        TurnoResponseDTO dto = new TurnoResponseDTO();
        dto.setId(turno.getId());
        dto.setFecha(turno.getFecha());
        dto.setEspecialidad(turno.getEspecialidad());
        dto.setMedico(turno.getMedico());
        dto.setPacienteNombre(turno.getPaciente().getNombre() + " " + turno.getPaciente().getApellido());
        dto.setPacienteId(turno.getPaciente().getId());
        return dto;
    }
}
