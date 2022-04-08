package br.com.exercicios.ilab.ecommerce.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicios.ilab.ecommerce.mysql.dao.PedidoDAO;
import br.com.exercicios.ilab.ecommerce.mysql.dto.Faturamento;
import br.com.exercicios.ilab.ecommerce.mysql.model.Pedido;
import br.com.exercicios.ilab.ecommerce.mysql.services.IPedidoService;
import br.com.exercicios.ilab.ecommerce.mysql.util.Mensagem;

@RestController
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	@Qualifier("dia-a-dia")
	private IPedidoService service;

	@PostMapping("/pedidos")
	public ResponseEntity<?> inserirNovo(@RequestBody Pedido novo) {
		Pedido resultado = service.adicionarPedido(novo);
		if (resultado != null) {
			return ResponseEntity.status(201).body(resultado);
		}
		return ResponseEntity.status(403).body(new Mensagem(1223, "Erro Teste"));
	}

	@DeleteMapping("/pedidos/{id}")
	public ResponseEntity<?> removerPedido(@PathVariable Integer id) {
		if (service.removerPedido(id)) {
			return ResponseEntity.ok(new Mensagem(123, "Ok"));
		}
		return ResponseEntity.badRequest().body(new Mensagem(999, "FAIL"));
	}

	@Autowired
	private PedidoDAO dao;

	@GetMapping("/pedidos")
	public List<Pedido> recuperarTodos() {
		return (List<Pedido>) dao.findAll();
	}

	@GetMapping("/faturamento")
	public List<Faturamento> recuperarFaturamento() {
		return dao.recuperarFaturamento();
	}

	@GetMapping("/faturamento/{ano}")
	public List<Faturamento> recuperarFaturamento(@PathVariable int ano) {
		return dao.recuperarFaturamentoPorAno(ano);
	}

}
