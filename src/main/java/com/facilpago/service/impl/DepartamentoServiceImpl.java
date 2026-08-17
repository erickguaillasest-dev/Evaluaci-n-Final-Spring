package com.facilpago.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facilpago.dto.DepartamentoRequestDTO;
import com.facilpago.dto.DepartamentoResponseDTO;
import com.facilpago.model.Departamento;
import com.facilpago.repository.DepartamentoRepository;
import com.facilpago.service.DepartamentoService;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DepartamentoResponseDTO> listarTodos() {
        return departamentoRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public DepartamentoResponseDTO obtenerPorNumero(String numeroDepartamento) {
        Departamento depto = departamentoRepository.findById(numeroDepartamento)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado: " + numeroDepartamento));
        return mapToResponseDTO(depto);
    }

    @Override
    @Transactional
    public DepartamentoResponseDTO guardar(DepartamentoRequestDTO request) {
        Departamento depto = new Departamento();
        depto.setNumeroDepartamento(request.getNumeroDepartamento());
        depto.setDescripcionDepartamento(request.getDescripcionDepartamento());

        Departamento guardado = departamentoRepository.save(depto);
        return mapToResponseDTO(guardado);
    }

    @Override
    @Transactional
    public void eliminar(String numeroDepartamento) {
        if (!departamentoRepository.existsById(numeroDepartamento)) {
            throw new RuntimeException("No existe el departamento: " + numeroDepartamento);
        }
        departamentoRepository.deleteById(numeroDepartamento);
    }

    private DepartamentoResponseDTO mapToResponseDTO(Departamento depto) {
        DepartamentoResponseDTO dto = new DepartamentoResponseDTO();
        dto.setNumeroDepartamento(depto.getNumeroDepartamento());
        dto.setDescripcionDepartamento(depto.getDescripcionDepartamento());
        return dto;
    }
}
