package com.kuiko.api_comunidades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuiko.api_comunidades.controller.exception.CustomNotFoundException;
import com.kuiko.api_comunidades.model.ComunidadAutonoma;
import com.kuiko.api_comunidades.repository.ComunidadRepository;

@Service
public class ComunidadService {

    @Autowired
    private ComunidadRepository comunidadRepository;

    public ComunidadAutonoma createComAutonoma(ComunidadAutonoma comunidadAutonoma) {
        if (comunidadAutonoma.getCodigo_ca() == null || comunidadAutonoma.getCodigo_ca().isBlank()) {
            throw new IllegalArgumentException("El código de la comunidad no puede ser nulo ni estar vacío");
        }
        if (comunidadRepository.existsById(comunidadAutonoma.getCodigo_ca())) {
            throw new IllegalArgumentException("Ya existe una ComunidadAutonoma con el código " + comunidadAutonoma.getCodigo_ca());
        }
        return comunidadRepository.save(comunidadAutonoma);
    }

    public ComunidadAutonoma getComAutonomaByCodCA(String codigoCa) {
        if (codigoCa == null || codigoCa.isBlank()) {
            throw new IllegalArgumentException("El código de la comunidad no puede ser nulo ni estar vacío");
        }
        return comunidadRepository.findById(codigoCa)
                .orElseThrow(() -> new CustomNotFoundException("ComunidadAutonoma con código " + codigoCa + " no encontrada"));
    }

    public List<ComunidadAutonoma> getAllComAutonomas() {
        return comunidadRepository.findAll();
    }

    public ComunidadAutonoma updateComAutonoma(String codigoCa, ComunidadAutonoma comunidadActualizada) {
        if (codigoCa == null || codigoCa.isBlank()) {
            throw new IllegalArgumentException("El código de la comunidad no puede ser nulo ni estar vacío");
        }
        if (comunidadActualizada.getCodigo_ca() == null || comunidadActualizada.getCodigo_ca().isBlank()) {
            throw new IllegalArgumentException("El código de la comunidad actualizada no puede ser nulo ni estar vacío");
        }
        ComunidadAutonoma existingComunidad = comunidadRepository.findById(codigoCa)
                .orElseThrow(() -> new CustomNotFoundException("ComunidadAutonoma con código " + codigoCa + " no encontrada"));

        existingComunidad.setNombre_ca(comunidadActualizada.getNombre_ca());

        return comunidadRepository.save(existingComunidad);
    }

    public boolean deleteComAutonoma(String codigoCa) {
        if (codigoCa == null || codigoCa.isBlank()) {
            throw new IllegalArgumentException("El código de la comunidad no puede ser nulo ni estar vacío");
        }
        if (comunidadRepository.existsById(codigoCa)) {
            comunidadRepository.deleteById(codigoCa);
            return true;
        } else {
            throw new CustomNotFoundException("ComunidadAutonoma con código " + codigoCa + " no encontrada");
        }
    }
}


