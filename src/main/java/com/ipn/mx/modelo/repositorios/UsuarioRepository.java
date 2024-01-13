package com.ipn.mx.modelo.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	//@Query("select m from Moto m where m.idUsuario = ?1")
	//public List<Moto> findMotos(String idUsuario);
}
