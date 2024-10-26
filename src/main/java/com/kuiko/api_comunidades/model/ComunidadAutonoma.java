package com.kuiko.api_comunidades.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="comunidad_autonoma")

public class ComunidadAutonoma {
	
	@Id
	private String codigo_ca;
	private String nombre_ca;
	
	
	public ComunidadAutonoma() {
			}
	
	
	public ComunidadAutonoma(String codigo_ca, String nombre_ca) {
		this.codigo_ca = codigo_ca;
		this.nombre_ca = nombre_ca;
	}


	public String getCodigo_ca() {
		return codigo_ca;
	}
	public void setCodigo_ca(String codigo_ca) {
		this.codigo_ca = codigo_ca;
	}
	public String getNombre_ca() {
		return nombre_ca;
	}
	public void setNombre_ca(String nombre_ca) {
		this.nombre_ca = nombre_ca;
	}
	
	
}
