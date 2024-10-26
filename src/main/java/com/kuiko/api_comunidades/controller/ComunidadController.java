package com.kuiko.api_comunidades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kuiko.api_comunidades.model.ComunidadAutonoma;
import com.kuiko.api_comunidades.service.ComunidadService;

import java.util.List;

@RestController
@RequestMapping("/api/comunidades-autonomas")
public class ComunidadController {

    private final ComunidadService comunidadService;

    @Autowired
    public ComunidadController(ComunidadService comunidadService) {
        this.comunidadService = comunidadService;
    }

    @PostMapping("/")
    public ResponseEntity<ComunidadAutonoma> createComunidad(@RequestBody ComunidadAutonoma comunidadAutonoma) {
        ComunidadAutonoma createdComunidad = comunidadService.createComAutonoma(comunidadAutonoma);
        return new ResponseEntity<>(createdComunidad, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ComunidadAutonoma>> getAllComunidades() {
        List<ComunidadAutonoma> comunidades = comunidadService.getAllComAutonomas();
        return ResponseEntity.ok(comunidades);
    }

    @GetMapping("/{caCode}")
    public ResponseEntity<ComunidadAutonoma> getComunidadByCode(@PathVariable("caCode") String caCode) {
        ComunidadAutonoma comunidad = comunidadService.getComAutonomaByCodCA(caCode);
        return comunidad != null ? ResponseEntity.ok(comunidad) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{caCode}")
    public ResponseEntity<ComunidadAutonoma> updateComunidad(@PathVariable("caCode") String caCode, @RequestBody ComunidadAutonoma comunidadActualizada) {
        ComunidadAutonoma updatedComunidad = comunidadService.updateComAutonoma(caCode, comunidadActualizada);
        return updatedComunidad != null ? ResponseEntity.ok(updatedComunidad) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{caCode}")
    public ResponseEntity<Void> deleteComunidad(@PathVariable("caCode") String caCode) {
        boolean deleted = comunidadService.deleteComAutonoma(caCode);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

