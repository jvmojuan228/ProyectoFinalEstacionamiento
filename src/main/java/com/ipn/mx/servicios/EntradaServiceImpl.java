package com.ipn.mx.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.entidades.Entrada;
import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.repositorios.EntradaRepository;

@Service
public class EntradaServiceImpl implements EntradaService{
	@Autowired
	EntradaRepository dao;

	@Override
	@Transactional(readOnly = true)
	public List<Entrada> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Entrada> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Entrada findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Entrada save(Entrada entrada) {
		return dao.save(entrada);
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
