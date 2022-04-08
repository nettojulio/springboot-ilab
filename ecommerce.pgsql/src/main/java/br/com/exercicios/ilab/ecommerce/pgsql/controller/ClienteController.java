package br.com.exercicios.ilab.ecommerce.pgsql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicios.ilab.ecommerce.pgsql.dto.ClienteDTO;
import br.com.exercicios.ilab.ecommerce.pgsql.services.IClienteService;

@RestController
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	private IClienteService service;

	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDTO>> recuperarTodos() {
		return ResponseEntity.ok(service.recuperarTodos());
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteDTO> recuperarPeloId(@PathVariable Integer id) {
		ClienteDTO res = service.recuperarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

}
