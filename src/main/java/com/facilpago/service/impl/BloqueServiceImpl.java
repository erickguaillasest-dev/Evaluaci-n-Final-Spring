package com.facilpago.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facilpago.dto.BloqueRequestDTO;
import com.facilpago.dto.BloqueResponseDTO;
import com.facilpago.model.Bloque;
import com.facilpago.repository.BloqueRepository;
import com.facilpago.service.BloqueService;

import java.util.List;

@Service
public class BloqueServiceImpl implements BloqueService {

    @Autowired
    private BloqueRepository bloqueRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BloqueResponseDTO> listarTodos() {
        return bloqueRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BloqueResponseDTO obtenerPorNumero(String numeroBloque) {
        Bloque bloque = bloqueRepository.findById(numeroBloque)
                .orElseThrow(() -> new RuntimeException("Bloque no encontrado: " + numeroBloque));
        return mapToResponseDTO(bloque);
    }

    @Override
    @Transactional
    public BloqueResponseDTO guardar(BloqueRequestDTO request) {
        Bloque bloque = new Bloque();
        bloque.setNumeroBloque(request.getNumeroBloque());
        bloque.setDescripcionBloque(request.getDescripcionBloque());
        bloque.setUbicacion(request.getUbicacion());

        Bloque guardado = bloqueRepository.save(bloque);
        return mapToResponseDTO(guardado);
    }

    @Override
    @Transactional
    public void eliminar(String numeroBloque) {
        if (!bloqueRepository.existsById(numeroBloque)) {
            throw new RuntimeException("No se puede eliminar. Bloque no existe: " + numeroBloque);
        }
        bloqueRepository.deleteById(numeroBloque);
    }

    private BloqueResponseDTO mapToResponseDTO(Bloque bloque) {
        BloqueResponseDTO dto = new BloqueResponseDTO();
        dto.setNumeroBloque(bloque.getNumeroBloque());
        dto.setDescripcionBloque(bloque.getDescripcionBloque());
        dto.setUbicacion(bloque.getUbicacion());
        return dto;
    }
}
