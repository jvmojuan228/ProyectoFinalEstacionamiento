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

import com.ipn.mx.modelo.entidades.Entrada;
import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.servicios.EntradaService;

@SpringBootApplication
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class EntradaController {
	@Autowired
	EntradaService service;
	
	@GetMapping("/entradas")
	public List<Entrada> readAll() {
		return service.findAll();
	}

	@PostMapping("/entradas")
	@ResponseStatus(HttpStatus.CREATED)
	public Entrada save(@RequestBody Entrada ent) {
		return service.save(ent);
	}

	@GetMapping("/entradas/{id}")
	public Entrada read(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/entradas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/entradas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Entrada update(@RequestBody Entrada ent, @PathVariable Long id) {
		Entrada c = service.findById(id);
		c.setFechahora(ent.getFechahora());
		return service.save(c);
	}
	
	@GetMapping("/entradas/motos")
	@ResponseStatus(HttpStatus.OK)
	public List<Moto> getMotos(){
		return service.findAllMoto();
	}
}
