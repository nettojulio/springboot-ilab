package br.com.exercicios.ilab.ecommerce.pgsql.services;

import java.util.List;

import br.com.exercicios.ilab.ecommerce.pgsql.dto.ClienteDTO;

public interface IClienteService {
	public List<ClienteDTO> recuperarTodos();

	public ClienteDTO recuperarPeloId(Integer id);
}
