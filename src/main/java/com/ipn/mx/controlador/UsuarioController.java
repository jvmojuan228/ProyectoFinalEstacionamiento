package com.ipn.mx.controlador;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.entidades.Usuario;
import com.ipn.mx.servicios.UsuarioService;

@SpringBootApplication
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	UsuarioService service;
	
	@GetMapping("/usuarios")
	public List<Usuario> readAll() {
		return (List<Usuario>)service.findAll();
	}

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario usuario) {
		return service.save(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public Usuario read(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario c = service.findById(id);
		c.setNombreUsuario(usuario.getNombreUsuario());
		c.setPaternoUsuario(usuario.getPaternoUsuario());
		c.setMaternoUsuario(usuario.getMaternoUsuario());
		return service.save(c);
	}
	
	
	@GetMapping(value = "/usuarios/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> reporteUsuarios() throws IOException {
		List<Usuario> listaDeAsistentes = (List<Usuario>) service.findAll();

		ByteArrayInputStream bis = service.reporteUsuarios(listaDeAsistentes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=listaDeUsuarios.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/usuarios/pdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> reporteMotos( @PathVariable long id ) throws IOException {
		System.out.println("id: " + id);
		List<Moto> listaMotos = service.findAllMoto(id);

		ByteArrayInputStream bis = service.reporteMoto(listaMotos);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=listaDeMotos.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	
}
