package com.kuiko.api_comunidades.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="comunidad_autonoma")

public class ComunidadAutonoma {
	
	@Id
    @NotNull(message = "El código de la comunidad no puede ser nulo")
    @NotBlank(message = "El código de la comunidad no puede estar vacío")
	private String codigo_ca;
	
    @NotNull(message = "El nombre de la comunidad no puede ser nulo")
    @NotBlank(message = "El nombre de la comunidad no puede estar vacío")
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
