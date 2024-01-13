package com.ipn.mx.servicios;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipn.mx.modelo.entidades.Entrada;
import com.ipn.mx.modelo.entidades.Moto;


public interface EntradaService {
	public List<Entrada> findAll();
	public Page<Entrada> findAll(Pageable pageable);
	public Entrada findById(Long id);
	public Entrada save(Entrada entrada);
	public void delete(Long id);

	//Recuperar las Categorias
	public List<Moto> findAllMoto();
	
	public ByteArrayInputStream reporteEntradas(List<Entrada> entradas);
}
