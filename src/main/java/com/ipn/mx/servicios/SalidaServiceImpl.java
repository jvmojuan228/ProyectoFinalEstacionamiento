package com.ipn.mx.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.entidades.Salida;
import com.ipn.mx.modelo.repositorios.SalidaRepository;

@Service
public class SalidaServiceImpl implements SalidaService {
	
	@Autowired
	SalidaRepository dao;

	@Override
	@Transactional(readOnly = true)
	public List<Salida> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Salida> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Salida findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Salida save(Salida salida) {
		return dao.save(salida);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Moto> findAllMoto() {
		return dao.findAllMotos();
	}
	
	
}
