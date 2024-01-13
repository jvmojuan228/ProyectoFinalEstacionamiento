package com.ipn.mx.servicios;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.entidades.Usuario;


public interface UsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario usuario);
	public void delete(Long id);
	public List<Moto> findAllMoto();
	
	public ByteArrayInputStream reporteMoto(List<Moto> moto);
	public ByteArrayInputStream reporteUsuarios(List<Usuario> usuario);
}
