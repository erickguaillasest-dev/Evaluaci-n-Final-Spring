package com.facilpago.service;

import java.util.List;

import com.facilpago.dto.CondominioRequestDTO;
import com.facilpago.dto.CondominioResponseDTO;

public interface CondominioService {
    List<CondominioResponseDTO> listarTodos();
    CondominioResponseDTO obtenerPorCedula(String cedula);
    CondominioResponseDTO guardar(CondominioRequestDTO request);
    void eliminar(String cedula);
}
