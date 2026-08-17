package com.facilpago.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facilpago.dto.DepartamentoRequestDTO;
import com.facilpago.dto.DepartamentoResponseDTO;
import com.facilpago.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(departamentoService.listarTodos());
    }

    @GetMapping("/{numeroDepartamento}")
    public ResponseEntity<DepartamentoResponseDTO> obtenerPorNumero(@PathVariable String numeroDepartamento) {
        return ResponseEntity.ok(departamentoService.obtenerPorNumero(numeroDepartamento));
    }

    @PostMapping
    public ResponseEntity<DepartamentoResponseDTO> guardar(@Valid @RequestBody DepartamentoRequestDTO request) {
        return new ResponseEntity<>(departamentoService.guardar(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{numeroDepartamento}")
    public ResponseEntity<Void> eliminar(@PathVariable String numeroDepartamento) {
        departamentoService.eliminar(numeroDepartamento);
        return ResponseEntity.noContent().build();
    }
}
