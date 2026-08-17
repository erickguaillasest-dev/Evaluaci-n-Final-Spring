package com.facilpago.service.mapper;

import org.springframework.stereotype.Component;

import com.facilpago.dto.DepartamentoRequestDTO;
import com.facilpago.dto.DepartamentoResponseDTO;
import com.facilpago.model.Departamento;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(DepartamentoRequestDTO request) {
        Departamento depto = new Departamento();
        depto.setNumeroDepartamento(request.getNumeroDepartamento());
        depto.setDescripcionDepartamento(request.getDescripcionDepartamento());
        return depto;
    }

    public DepartamentoResponseDTO toDTO(Departamento depto) {
        DepartamentoResponseDTO dto = new DepartamentoResponseDTO();
        dto.setNumeroDepartamento(depto.getNumeroDepartamento());
        dto.setDescripcionDepartamento(depto.getDescripcionDepartamento());
        return dto;
    }
}