package com.kuiko.api_comunidades.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comunidad_autonoma")
@Data
public class ComunidadAutonoma {
	
	@Id
	private String codigo_ca;
	private String nombre_ca;
}
