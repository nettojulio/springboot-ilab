package br.com.exercicios.ilab.ecommerce.pgsql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.exercicios.ilab.ecommerce.pgsql.dto.Faturamento;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
	@Query("SELECT new "
			+ " br.com.exercicios.ilab.ecommerce.pgsql.dto.Faturamento(month (pedido.data), sum(pedido.valorTotal)) "
			+ " FROM " + " Pedido as pedido " + "GROUP BY month(pedido.data) ")
	public List<Faturamento> recuperarFaturamento();

	@Query("SELECT new "
			+ " br.com.exercicios.ilab.ecommerce.pgsql.dto.Faturamento(month (pedido.data), sum(pedido.valorTotal)) "
			+ " FROM " + " Pedido as pedido " + " WHERE year(pedido.data) = :ano " + "GROUP BY month(pedido.data) ")
	public List<Faturamento> recuperarFaturamentoPorAno(@Param("ano") int ano);

}
