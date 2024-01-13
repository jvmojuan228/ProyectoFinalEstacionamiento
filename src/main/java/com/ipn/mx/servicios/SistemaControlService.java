package com.ipn.mx.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.SistemaControl;

public interface SistemaControlService {
	public List<SistemaControl> findAll();
	public SistemaControl findById(Long id);
	public SistemaControl save(SistemaControl sc);
	public void delete(Long id);
}
