package br.com.exercicios.ilab.ecommerce.mysql.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.exercicios.ilab.ecommerce.mysql.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer> {
	public List<Departamento> findByOrderByNomeAsc();
}
