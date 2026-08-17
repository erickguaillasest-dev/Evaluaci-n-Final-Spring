package com.facilpago.service;

import java.util.List;

import com.facilpago.dto.DepartamentoRequestDTO;
import com.facilpago.dto.DepartamentoResponseDTO;

public interface DepartamentoService {
    List<DepartamentoResponseDTO> listarTodos();
    DepartamentoResponseDTO obtenerPorNumero(String numeroDepartamento);
    DepartamentoResponseDTO guardar(DepartamentoRequestDTO request);
    void eliminar(String numeroDepartamento);
}