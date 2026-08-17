package com.facilpago.service.mapper;

import org.springframework.stereotype.Component;

import com.facilpago.dto.CondominioRequestDTO;
import com.facilpago.dto.CondominioResponseDTO;
import com.facilpago.model.Bloque;
import com.facilpago.model.Condominio;
import com.facilpago.model.Departamento;

@Component
public class CondominioMapper {

    public Condominio toEntity(CondominioRequestDTO request, Bloque bloque, Departamento departamento) {
        Condominio c = new Condominio();
        c.setCedulaCondomino(request.getCedulaCondomino());
        c.setNombreCondomino(request.getNombreCondomino());
        c.setApellidoCondomino(request.getApellidoCondomino());
        c.setCelularCondomino(request.getCelularCondomino());
        c.setTelefonoCondomino(request.getTelefonoCondomino());
        c.setBloque(bloque);
        c.setDepartamento(departamento);
        return c;
    }

    public CondominioResponseDTO toDTO(Condominio c) {
        CondominioResponseDTO dto = new CondominioResponseDTO();
        dto.setCedulaCondomino(c.getCedulaCondomino());
        dto.setNombreCondomino(c.getNombreCondomino());
        dto.setApellidoCondominio(c.getApellidoCondomino());
        dto.setCelularCondomino(c.getCelularCondomino());
        dto.setTelefonoCondominio(c.getTelefonoCondomino());
        if (c.getBloque() != null) {
            dto.setNumeroBloque(c.getBloque().getNumeroBloque());
        }
        if (c.getDepartamento() != null) {
            dto.setNumeroDepartamento(c.getDepartamento().getNumeroDepartamento());
        }
        return dto;
    }
}