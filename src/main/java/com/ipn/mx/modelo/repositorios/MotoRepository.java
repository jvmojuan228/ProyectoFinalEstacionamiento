package com.ipn.mx.modelo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ipn.mx.modelo.entidades.Entrada;
import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.entidades.Usuario;


public interface MotoRepository extends JpaRepository<Moto, Long>{

	@Query("from Usuario")
	public List<Usuario> findAllUsers();
	
	@Query("select e from Entrada e where e.idMoto = ?1")
	public List<Entrada> findEntradas(long idMoto);
	
	@Query("select s from Entrada s where s.idMoto = ?1")
	public List<Entrada> findSalidas(long idMoto);
}
