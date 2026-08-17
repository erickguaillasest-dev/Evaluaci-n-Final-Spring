package com.facilpago.service.mapper;

import org.springframework.stereotype.Component;

import com.facilpago.dto.PagoRequestDTO;
import com.facilpago.dto.PagoResponseDTO;
import com.facilpago.model.Condominio;
import com.facilpago.model.Pago;

@Component
public class PagoMapper {

    public Pago toEntity(PagoRequestDTO request, Condominio condomino) {
        Pago p = new Pago();
        p.setFechaPago(request.getFechaPago());
        p.setAnioMesPago(request.getAnioMesPago());
        p.setValorPagoAlicuota(request.getValorPagoAlicuota());
        p.setValorPagoConsumoServicios(request.getValorPagoConsumoServicios());
        p.setCondomino(condomino);
        return p;
    }

    public PagoResponseDTO toDTO(Pago p) {
        PagoResponseDTO dto = new PagoResponseDTO();
        dto.setId(p.getId());
        dto.setFechaPago(p.getFechaPago());
        dto.setAnioMesPago(p.getAnioMesPago());
        dto.setValorPagoAlicuota(p.getValorPagoAlicuota());
        dto.setValorPagoConsumoServicios(p.getValorPagoConsumoServicios());
        if (p.getCondomino() != null) {
            dto.setCedulaCondomino(p.getCondomino().getCedulaCondomino());
        }
        return dto;
    }
}