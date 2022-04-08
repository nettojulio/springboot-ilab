package br.com.exercicios.ilab.ecommerce.mysql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.exercicios.ilab.ecommerce.mysql.dao.PedidoDAO;
import br.com.exercicios.ilab.ecommerce.mysql.model.ItemPedido;
import br.com.exercicios.ilab.ecommerce.mysql.model.Pedido;

@Component
//@Primary
@Qualifier("desconto")
public class PedidoServiceDesconto implements IPedidoService {

	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido adicionarPedido(Pedido novo) {
		System.out.println("Nova lógica!");

		for (ItemPedido item : novo.getItens()) {
			item.setPedido(novo);
		}

		if (novo.getValor_bruto() >= 1000.00) {
			double desconto = novo.getValor_bruto() * 0.1;
			novo.setDesconto(desconto);
			novo.setValor_total(novo.getValor_bruto() - desconto);
		}
		Pedido p = dao.save(novo);
		return p;
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
