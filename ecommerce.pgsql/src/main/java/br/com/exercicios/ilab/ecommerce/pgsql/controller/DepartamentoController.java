package br.com.exercicios.ilab.ecommerce.pgsql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicios.ilab.ecommerce.pgsql.dao.DepartamentoDAO;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Departamento;

@RestController
@CrossOrigin("*")
public class DepartamentoController {

	@Autowired
	private DepartamentoDAO dao;

	@GetMapping("/departamentos")
	public List<Departamento> recuperarTodos() {
		return (List<Departamento>) dao.findAll();
	}

	@PostMapping("/departamentos")
	public Departamento incluirNovo(@RequestBody Departamento novo) {
		return dao.save(novo);
	}

	@PutMapping("/departamentos")
	public Departamento alterarDepartamento(@RequestBody Departamento atual) {
		return dao.save(atual);
	}

}
