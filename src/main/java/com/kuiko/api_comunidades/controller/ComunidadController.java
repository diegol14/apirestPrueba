package com.kuiko.api_comunidades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.kuiko.api_comunidades.ComunidadService;
import com.kuiko.api_comunidades.model.ComunidadAutonoma;

@RestController
@RequestMapping("api/comunidades-autonomas")
public class ComunidadController {
	
	@Autowired
	private ComunidadService comunidadService;
	
	@PostMapping
	public ComunidadAutonoma createComAutonoma(ComunidadAutonoma comunidadAutonoma) {
		return createComAutonoma(comunidadAutonoma );
	}
	
	@GetMapping
	public List<ComunidadAutonoma> getAllComAutonomas(){
		return comunidadService.getAllComAutonomas();
	}
	
	@GetMapping("{caCode}")
	public ComunidadAutonoma searchByCode(@PathVariable("caCode") String caCode) {
		return comunidadService.getComAutonomaByCodCA(caCode);
	}
	
	@DeleteMapping("{caCode}")
	public void deleteCaByCode(@PathVariable("caCode") String caCode) {
		comunidadService.deleteComAutonoma(caCode);
	}

}
