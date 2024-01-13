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

import com.ipn.mx.modelo.entidades.SistemaControl;
import com.ipn.mx.servicios.SistemaControlService;

@SpringBootApplication
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class SistemaControlController {
	@Autowired
	SistemaControlService service;
	
	@GetMapping("/sc")
	public List<SistemaControl> readAll() {
		return service.findAll();
	}

	@PostMapping("/sc")
	@ResponseStatus(HttpStatus.CREATED)
	public SistemaControl save(@RequestBody SistemaControl sc) {
		return service.save(sc);
	}

	@GetMapping("/sc/{id}")
	public SistemaControl read(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/sc/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/sc/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public SistemaControl update(@RequestBody SistemaControl sc, @PathVariable Long id) {
		SistemaControl c = service.findById(id);
		c.setAcceso(sc.getAcceso());
		return service.save(c);
	}
}
