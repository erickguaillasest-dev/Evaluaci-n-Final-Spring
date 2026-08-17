package com.facilpago.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facilpago.dto.CondominioRequestDTO;
import com.facilpago.dto.CondominioResponseDTO;
import com.facilpago.service.CondominioService;

import java.util.List;

@RestController
@RequestMapping("/api/condominios")
@CrossOrigin(origins = "*")
public class CondominioController {

    @Autowired
    private CondominioService condominioService;

    @GetMapping
    public ResponseEntity<List<CondominioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(condominioService.listarTodos());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<CondominioResponseDTO> obtenerPorCedula(@PathVariable String cedula) {
        return ResponseEntity.ok(condominioService.obtenerPorCedula(cedula));
    }

    @PostMapping
    public ResponseEntity<CondominioResponseDTO> guardar(@Valid @RequestBody CondominioRequestDTO request) {
        return new ResponseEntity<>(condominioService.guardar(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        condominioService.eliminar(cedula);
        return ResponseEntity.noContent().build();
    }
}
