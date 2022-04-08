package br.com.exercicios.ilab.ecommerce.pgsql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.exercicios.ilab.ecommerce.pgsql.dto.ClienteDTO;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{
	
	@Query("    SELECT "
			+ "new br.com.exercicios.ilab.ecommerce.pgsql.dto.ClienteDTO("
			+ "  cliente.numero,"
			+ "  cliente.nome,"
			+ "  cliente.cpf,"
			+ "  cliente.email,"
			+ "  cliente.telefone) "
			+ "FROM Cliente as cliente")
	public List<ClienteDTO> recuperarTodos();
	
	@Query(" SELECT "
			+ " new br.com.exercicios.ilab.ecommerce.pgsql.dto.ClienteDTO("
			+ "  cliente.numero,"
			+ "  cliente.nome,"
			+ "  cliente.cpf,"
			+ "  cliente.email,"
			+ "  cliente.telefone)"
			+ "FROM Cliente as cliente WHERE cliente.numero = :numero")
	public ClienteDTO recuperarPeloId(@Param("numero") Integer numero);

}


