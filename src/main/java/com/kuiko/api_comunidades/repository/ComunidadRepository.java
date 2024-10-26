package com.kuiko.api_comunidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuiko.api_comunidades.model.ComunidadAutonoma; 



@Repository
public interface ComunidadRepository extends JpaRepository<ComunidadAutonoma, String> {

}