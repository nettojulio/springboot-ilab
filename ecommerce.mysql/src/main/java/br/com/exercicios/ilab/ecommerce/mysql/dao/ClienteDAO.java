package br.com.exercicios.ilab.ecommerce.mysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.exercicios.ilab.ecommerce.mysql.dto.ClienteDTO;
import br.com.exercicios.ilab.ecommerce.mysql.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{
	
	@Query("    SELECT "
			+ "new br.com.exercicios.ilab.ecommerce.mysql.dto.ClienteDTO("
			+ "  cliente.numero,"
			+ "  cliente.nome,"
			+ "  cliente.cpf,"
			+ "  cliente.email,"
			+ "  cliente.telefone) "
			+ "FROM Cliente as cliente")
	public List<ClienteDTO> recuperarTodos();
	
	@Query(" SELECT "
			+ " new br.com.exercicios.ilab.ecommerce.mysql.dto.ClienteDTO("
			+ "  cliente.numero,"
			+ "  cliente.nome,"
			+ "  cliente.cpf,"
			+ "  cliente.email,"
			+ "  cliente.telefone)"
			+ "FROM Cliente as cliente WHERE cliente.numero = :numero")
	public ClienteDTO recuperarPeloId(@Param("numero") Integer numero);

}











