package com.ipn.mx.modelo.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ipn.mx.modelo.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("select e from Usuario e where e.nombreUsuario like %?1%")
	public List<Usuario> findByNombre(String nombre);
}
