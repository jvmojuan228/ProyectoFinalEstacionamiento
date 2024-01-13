package com.ipn.mx.servicios;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ipn.mx.modelo.entidades.Entrada;
import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.entidades.Salida;
import com.ipn.mx.modelo.entidades.Usuario;

public interface MotoService {
	public List<Moto> findAll();
	public Page<Moto> findAll(Pageable pageable);
	public Moto findById(Long id);
	public Moto save(Moto moto);
	public void delete(Long id);
	
	//Recuperar las Categorias
	public List<Usuario> findAllUsuario();
		
	public ByteArrayInputStream reporteMotos(List<Moto> moto);
	
	public ByteArrayInputStream reporteMoto(List<Entrada> entradas, List<Salida> salidas);
	
}
