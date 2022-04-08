package br.com.exercicios.ilab.ecommerce.mysql.services;

import java.util.List;

import br.com.exercicios.ilab.ecommerce.mysql.dto.ClienteDTO;

public interface IClienteService {
	public List<ClienteDTO> recuperarTodos();

	public ClienteDTO recuperarPeloId(Integer id);
}
