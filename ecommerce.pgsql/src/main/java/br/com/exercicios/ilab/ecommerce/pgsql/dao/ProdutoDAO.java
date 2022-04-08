package br.com.exercicios.ilab.ecommerce.pgsql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.exercicios.ilab.ecommerce.pgsql.model.Departamento;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
	public List<Produto> findByNomeContainingOrDescricaoContaining(String pcNome, String pcDescricao);
	public List<Produto> findByOrderByNomeAsc();
	public List<Produto> findByOrderByPrecoAsc();
	public List<Produto> findByOrderByPrecoDesc();
	public List<Produto> findByDpto(Departamento d);

	@Query("SELECT new "
			+ " br.com.exercicios.ilab.ecommerce.pgsql.model.Produto(produto.codigo, produto.nome, produto.descricao, produto.preco, produto.qtdEstoque, produto.linkFoto, departamento.numero, departamento.nome, departamento.andar) "
			+ " FROM " + " Produto as produto INNER JOIN Departamento as departamento ON "
			+ "produto.dpto.numero = departamento.numero")
	public List<Produto> recuperarTudaoComUmaUnicaQuery();
}
