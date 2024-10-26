package com.kuiko.api_comunidades.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuiko.api_comunidades.controller.exception.*;
import com.kuiko.api_comunidades.model.ComunidadAutonoma;
import com.kuiko.api_comunidades.repository.ComunidadRepository;

@Service
public class ComunidadService {

    @Autowired
    private ComunidadRepository comunidadRepository;

    public ComunidadAutonoma createComAutonoma(ComunidadAutonoma comunidadAutonoma) {
        return comunidadRepository.save(comunidadAutonoma);
    }

    public ComunidadAutonoma getComAutonomaByCodCA(String codigoCa) {
        return comunidadRepository.findById(codigoCa)
                .orElseThrow(() -> new CustomNotFoundException("ComunidadAutonoma con código " + codigoCa + " no encontrada"));
    }

    public List<ComunidadAutonoma> getAllComAutonomas() {
        return comunidadRepository.findAll();
    }

    public ComunidadAutonoma updateComAutonoma(String codigoCa, ComunidadAutonoma comunidadActualizada) {
        ComunidadAutonoma existingComunidad = comunidadRepository.findById(codigoCa)
                .orElseThrow(() -> new CustomNotFoundException("ComunidadAutonoma con código " + codigoCa + " no encontrada"));

        // Actualizamos los campos necesarios
        existingComunidad.setNombre_ca(comunidadActualizada.getNombre_ca());

        return comunidadRepository.save(existingComunidad);
    }

    public boolean deleteComAutonoma(String codigoCa) {
        if (!comunidadRepository.existsById(codigoCa)) {
            throw new CustomNotFoundException("ComunidadAutonoma con código " + codigoCa + " no encontrada");
        }
        comunidadRepository.deleteById(codigoCa);
        return true;
    }
}

