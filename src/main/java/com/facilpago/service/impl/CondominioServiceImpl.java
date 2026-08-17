package com.facilpago.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facilpago.dto.CondominioRequestDTO;
import com.facilpago.dto.CondominioResponseDTO;
import com.facilpago.model.Bloque;
import com.facilpago.model.Condominio;
import com.facilpago.model.Departamento;
import com.facilpago.repository.BloqueRepository;
import com.facilpago.repository.CondominioRepository;
import com.facilpago.repository.DepartamentoRepository;
import com.facilpago.service.CondominioService;

import java.util.List;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    @Autowired
    private BloqueRepository bloqueRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CondominioResponseDTO> listarTodos() {
        return condominioRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CondominioResponseDTO obtenerPorCedula(String cedula) {
        Condominio c = condominioRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Condómino no encontrado: " + cedula));
        return mapToResponseDTO(c);
    }

    @Override
    @Transactional
    public CondominioResponseDTO guardar(CondominioRequestDTO request) {
        Bloque bloque = bloqueRepository.findById(request.getNumeroBloque())
                .orElseThrow(() -> new RuntimeException("Bloque no existe: " + request.getNumeroBloque()));

        Departamento depto = departamentoRepository.findById(request.getNumeroDepartamento())
                .orElseThrow(() -> new RuntimeException("Departamento no existe: " + request.getNumeroDepartamento()));

        Condominio c = new Condominio();
        c.setCedulaCondomino(request.getCedulaCondomino());
        c.setNombreCondomino(request.getNombreCondomino());
        c.setApellidoCondomino(request.getApellidoCondomino());
        c.setCelularCondomino(request.getCelularCondomino());
        c.setTelefonoCondomino(request.getTelefonoCondomino());
        c.setBloque(bloque);
        c.setDepartamento(depto);

        Condominio guardado = condominioRepository.save(c);
        return mapToResponseDTO(guardado);
    }

    @Override
    @Transactional
    public void eliminar(String cedula) {
        if (!condominioRepository.existsById(cedula)) {
            throw new RuntimeException("Condómino no existe: " + cedula);
        }
        condominioRepository.deleteById(cedula);
    }

    private CondominioResponseDTO mapToResponseDTO(Condominio c) {
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