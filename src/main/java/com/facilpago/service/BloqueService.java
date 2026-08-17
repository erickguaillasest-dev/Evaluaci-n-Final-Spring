package com.facilpago.service;

import java.util.List;

import com.facilpago.dto.BloqueRequestDTO;
import com.facilpago.dto.BloqueResponseDTO;

public interface BloqueService {
    List<BloqueResponseDTO> listarTodos();
    BloqueResponseDTO obtenerPorNumero(String numeroBloque);
    BloqueResponseDTO guardar(BloqueRequestDTO request);
    void eliminar(String numeroBloque);
}
