package br.com.exercicios.ilab.ecommerce.pgsql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.exercicios.ilab.ecommerce.pgsql.dao.PedidoDAO;
import br.com.exercicios.ilab.ecommerce.pgsql.model.ItemPedido;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Pedido;

@Qualifier("dia-a-dia")
@Component
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido adicionarPedido(Pedido novo) {

		for (ItemPedido item : novo.getItens()) {
			item.setPedido(novo);
		}

		Pedido resultado = dao.save(novo);
		return resultado;
	}

	@Override
	public boolean removerPedido(Integer id) {
		try {
			dao.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
