package com.ipn.mx.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
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
import com.ipn.mx.modelo.entidades.Salida;
import com.ipn.mx.servicios.SalidaService;

@SpringBootApplication
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class SalidaController {
	@Autowired
	SalidaService service;
	
	@GetMapping("/salidas")
	public List<Salida> readAll() {
		return service.findAll();
	}

	@PostMapping("/salidas")
	@ResponseStatus(HttpStatus.CREATED)
	public Salida save(@RequestBody Salida ent) {
		return service.save(ent);
	}

	@GetMapping("/salidas/{id}")
	public Salida read(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/salidas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/salidas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Salida update(@RequestBody Salida ent, @PathVariable Long id) {
		Salida c = service.findById(id);
		c.setFechahora(ent.getFechahora());
		return service.save(c);
	}
	
	@GetMapping("/salidas/motos")
	@ResponseStatus(HttpStatus.OK)
	public List<Moto> getMotos(){
		return service.findAllMoto();
	}
}
