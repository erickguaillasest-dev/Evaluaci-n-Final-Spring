package com.facilpago.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facilpago.dto.CondominioRequestDTO;
import com.facilpago.dto.CondominioResponseDTO;
import com.facilpago.service.CondominioService;

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
    public ResponseEntity<CondominioResponseDTO> guardar(@RequestBody CondominioRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(condominioService.guardar(request));
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<CondominioResponseDTO> actualizar(@PathVariable String cedula, @RequestBody CondominioRequestDTO request) {
        return ResponseEntity.ok(condominioService.actualizar(cedula, request));
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        condominioService.eliminar(cedula);
        return ResponseEntity.noContent().build();
    }
}