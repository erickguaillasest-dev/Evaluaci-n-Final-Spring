package com.facilpago.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facilpago.dto.BloqueRequestDTO;
import com.facilpago.dto.BloqueResponseDTO;
import com.facilpago.service.BloqueService;

import java.util.List;

@RestController
@RequestMapping("/api/bloques")
@CrossOrigin(origins = "*")
public class BloqueController {

    @Autowired
    private BloqueService bloqueService;

    @GetMapping
    public ResponseEntity<List<BloqueResponseDTO>> listarTodos() {
        return ResponseEntity.ok(bloqueService.listarTodos());
    }

    @GetMapping("/{numeroBloque}")
    public ResponseEntity<BloqueResponseDTO> obtenerPorNumero(@PathVariable String numeroBloque) {
        return ResponseEntity.ok(bloqueService.obtenerPorNumero(numeroBloque));
    }

    @PostMapping
    public ResponseEntity<BloqueResponseDTO> guardar(@Valid @RequestBody BloqueRequestDTO request) {
        return new ResponseEntity<>(bloqueService.guardar(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{numeroBloque}")
    public ResponseEntity<Void> eliminar(@PathVariable String numeroBloque) {
        bloqueService.eliminar(numeroBloque);
        return ResponseEntity.noContent().build();
    }
}