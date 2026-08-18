package com.facilpago.service.impl;

import java.util.List;
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
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CondominioResponseDTO obtenerPorCedula(String cedula) {
        Condominio condominio = condominioRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Condómino no encontrado con cédula: " + cedula));
        return mapToDTO(condominio);
    }

    @Override
    @Transactional
    public CondominioResponseDTO guardar(CondominioRequestDTO request) {
        if (request.getCedulaCondomino() == null || request.getCedulaCondomino().trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula del condómino es obligatoria.");
        }

        if (condominioRepository.existsById(request.getCedulaCondomino())) {
            throw new RuntimeException("Ya existe un condómino registrado con la cédula: " + request.getCedulaCondomino());
        }

        Condominio condominio = new Condominio();
        condominio.setCedulaCondomino(request.getCedulaCondomino());
        
        mapearDatosYEstablecerRelaciones(condominio, request);

        Condominio guardado = condominioRepository.save(condominio);
        return mapToDTO(guardado);
    }

    @Override
    @Transactional
    public CondominioResponseDTO actualizar(String cedula, CondominioRequestDTO request) {
        Condominio condominio = condominioRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Condómino no encontrado para actualizar: " + cedula));

        mapearDatosYEstablecerRelaciones(condominio, request);

        Condominio actualizado = condominioRepository.save(condominio);
        return mapToDTO(actualizado);
    }

    @Override
    @Transactional
    public void eliminar(String cedula) {
        if (!condominioRepository.existsById(cedula)) {
            throw new RuntimeException("Condómino no encontrado para eliminar: " + cedula);
        }
        condominioRepository.deleteById(cedula);
    }

    private void mapearDatosYEstablecerRelaciones(Condominio condominio, CondominioRequestDTO request) {
        Bloque bloque = bloqueRepository.findById(request.getNumeroBloque())
                .orElseThrow(() -> new RuntimeException("Bloque no encontrado ID: " + request.getNumeroBloque()));

        Departamento departamento = departamentoRepository.findById(request.getNumeroDepartamento())
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado ID: " + request.getNumeroDepartamento()));

        condominio.setNombreCondomino(request.getNombreCondomino());
        condominio.setApellidoCondomino(request.getApellidoCondomino());
        condominio.setCelularCondomino(request.getCelularCondomino());
        condominio.setTelefonoCondomino(request.getTelefonoCondomino());
        condominio.setBloque(bloque);
        condominio.setDepartamento(departamento);
    }

    private CondominioResponseDTO mapToDTO(Condominio c) {
        CondominioResponseDTO dto = new CondominioResponseDTO();
        dto.setCedulaCondomino(c.getCedulaCondomino());
        dto.setNombreCondomino(c.getNombreCondomino());
        dto.setApellidoCondominio(c.getApellidoCondomino());
        dto.setCelularCondomino(c.getCelularCondomino());
        dto.setTelefonoCondominio(c.getTelefonoCondomino());
        if (c.getBloque() != null) dto.setNumeroBloque(c.getBloque().getNumeroBloque());
        if (c.getDepartamento() != null) dto.setNumeroDepartamento(c.getDepartamento().getNumeroDepartamento());
        return dto;
    }
}