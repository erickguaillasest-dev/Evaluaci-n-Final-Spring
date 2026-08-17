package com.facilpago.service.mapper;

import org.springframework.stereotype.Component;

import com.facilpago.dto.BloqueRequestDTO;
import com.facilpago.dto.BloqueResponseDTO;
import com.facilpago.model.Bloque;

@Component
public class BloqueMapper {

    public Bloque toEntity(BloqueRequestDTO request) {
        Bloque bloque = new Bloque();
        bloque.setNumeroBloque(request.getNumeroBloque());
        bloque.setDescripcionBloque(request.getDescripcionBloque());
        bloque.setUbicacion(request.getUbicacion());
        return bloque;
    }

    public BloqueResponseDTO toDTO(Bloque bloque) {
        BloqueResponseDTO dto = new BloqueResponseDTO();
        dto.setNumeroBloque(bloque.getNumeroBloque());
        dto.setDescripcionBloque(bloque.getDescripcionBloque());
        dto.setUbicacion(bloque.getUbicacion());
        return dto;
    }
}
