package com.facilpago.service;

import java.util.List;

import com.facilpago.dto.PagoRequestDTO;
import com.facilpago.dto.PagoResponseDTO;


public interface PagoService {
    List<PagoResponseDTO> listarTodos();
    PagoResponseDTO obtenerPorId(Long id);
    PagoResponseDTO guardar(PagoRequestDTO request);
    void eliminar(Long id);
}