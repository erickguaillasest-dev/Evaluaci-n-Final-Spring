package com.facilpago.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facilpago.dto.PagoRequestDTO;
import com.facilpago.dto.PagoResponseDTO;
import com.facilpago.model.Condominio;
import com.facilpago.model.Pago;
import com.facilpago.repository.CondominioRepository;
import com.facilpago.repository.PagoRepository;
import com.facilpago.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CondominioRepository condominioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PagoResponseDTO> listarTodos() {
        return pagoRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PagoResponseDTO obtenerPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del pago no puede ser nulo.");
        }
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado ID: " + id));
        return mapToResponseDTO(pago);
    }

    @Override
    @Transactional
    public PagoResponseDTO guardar(PagoRequestDTO request) {
        if (request == null || request.getCedulaCondomino() == null || request.getCedulaCondomino().trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula del condómino no puede ser nula ni vacía.");
        }

        Condominio condomino = condominioRepository.findById(request.getCedulaCondomino())
                .orElseThrow(() -> new RuntimeException("Condómino no existe con cédula: " + request.getCedulaCondomino()));

        Pago pago = new Pago();
        pago.setFechaPago(request.getFechaPago());
        pago.setAnioMesPago(request.getAnioMesPago());
        pago.setValorPagoAlicuota(request.getValorPagoAlicuota());
        pago.setValorPagoConsumoServicios(request.getValorPagoConsumoServicios());
        pago.setCondomino(condomino);

        Pago guardado = pagoRepository.save(pago);
        return mapToResponseDTO(guardado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (id == null || !pagoRepository.existsById(id)) {
            throw new RuntimeException("Pago no existe ID: " + id);
        }
        pagoRepository.deleteById(id);
    }

    private PagoResponseDTO mapToResponseDTO(Pago pago) {
        PagoResponseDTO dto = new PagoResponseDTO();
        dto.setId(pago.getId());
        dto.setFechaPago(pago.getFechaPago());
        dto.setAnioMesPago(pago.getAnioMesPago());
        dto.setValorPagoAlicuota(pago.getValorPagoAlicuota());
        dto.setValorPagoConsumoServicios(pago.getValorPagoConsumoServicios());

        if (pago.getCondomino() != null) {
            dto.setCedulaCondomino(pago.getCondomino().getCedulaCondomino());
        }

        return dto;
    }
}