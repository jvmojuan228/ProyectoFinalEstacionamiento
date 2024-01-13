package com.ipn.mx.modelo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ipn.mx.modelo.entidades.Entrada;
import com.ipn.mx.modelo.entidades.Moto;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {
	@Query("from Moto")
	public List<Moto> findAllMotos();
	
}
