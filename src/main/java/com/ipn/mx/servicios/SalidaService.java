package com.ipn.mx.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ipn.mx.modelo.entidades.Salida;
import com.ipn.mx.modelo.entidades.Moto;

public interface SalidaService {
	public List<Salida> findAll();
	public Page<Salida> findAll(Pageable pageable);
	public Salida findById(Long id);
	public Salida save(Salida salida);
	public void delete(Long id);

	//Recuperar las Categorias
	public List<Moto> findAllMoto();
	
}
