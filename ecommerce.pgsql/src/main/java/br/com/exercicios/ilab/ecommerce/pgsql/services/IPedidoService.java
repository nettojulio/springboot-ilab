package br.com.exercicios.ilab.ecommerce.pgsql.services;

import br.com.exercicios.ilab.ecommerce.pgsql.model.Pedido;

public interface IPedidoService {
	// recebe um param do tipo pedido (s/n) e retorno o mesmo objeto agora criado no banco
	public Pedido adicionarPedido(Pedido novo);
	public boolean removerPedido(Integer id);

}
