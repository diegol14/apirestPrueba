package com.kuiko.api_comunidades;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuiko.api_comunidades.model.ComunidadAutonoma;
import com.kuiko.api_comunidades.repository.ComunidadRepository;

@Component
public class ComunidadService {
	@Autowired
	private ComunidadRepository comunidadRepository;
	
	public ComunidadAutonoma createComAutonoma(ComunidadAutonoma comunidadAutonoma) {
		return comunidadRepository.save(comunidadAutonoma);
	}
	
	public ComunidadAutonoma getComAutonomaByCodCA (String caCode) {
		Optional<ComunidadAutonoma> optionalComunidadAutonoma = comunidadRepository.findById(caCode);
		return optionalComunidadAutonoma.get();
		}
	
	public List<ComunidadAutonoma> getAllComAutonomas(){
		return comunidadRepository.findAll();
		}
	
	public void deleteComAutonoma(String caCode) {
		comunidadRepository.deleteById(caCode);
	}
	
}
