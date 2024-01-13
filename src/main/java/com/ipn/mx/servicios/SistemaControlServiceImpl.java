package com.ipn.mx.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.entidades.SistemaControl;
import com.ipn.mx.modelo.repositorios.SistemaControlRepository;

@Service
public class SistemaControlServiceImpl implements SistemaControlService {

	@Autowired
	SistemaControlRepository dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<SistemaControl> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public SistemaControl findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public SistemaControl save(SistemaControl sc) {
		return dao.save(sc);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}

}
