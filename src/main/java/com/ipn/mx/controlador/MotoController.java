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
import com.ipn.mx.servicios.MotoService;

@SpringBootApplication
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class MotoController {
	@Autowired
	MotoService service;
	
	@GetMapping("/motos")
	public List<Moto> readAll() {
		return service.findAll();
	}

	@PostMapping("/motos")
	@ResponseStatus(HttpStatus.CREATED)
	public Moto save(@RequestBody Moto moto) {
		return service.save(moto);
	}

	@GetMapping("/motos/{id}")
	public Moto read(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/motos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/motos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Moto update(@RequestBody Moto moto, @PathVariable Long id) {
		Moto c = service.findById(id);
		c.setMarcaMoto(moto.getMarcaMoto());
		c.setModeloMoto(moto.getModeloMoto());
		c.setPlacasMoto(moto.getPlacasMoto());
		c.setSerieMoto(moto.getSerieMoto());
		return service.save(c);
	}
	
	@GetMapping(value = "/motos/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> reporteMotos() throws IOException {
		List<Moto> listaDeAsistentes = (List<Moto>) service.findAll();

		ByteArrayInputStream bis = service.reporteMotos(listaDeAsistentes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=listaDeMotos.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/motos/pdf/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> reporteMoto(@PathVariable Long id) throws IOException {
		

		ByteArrayInputStream bis = service.reporteMoto(id);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=listaDeAccesos.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
}
