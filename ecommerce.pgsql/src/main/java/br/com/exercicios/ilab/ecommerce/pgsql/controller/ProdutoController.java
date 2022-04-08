package br.com.exercicios.ilab.ecommerce.pgsql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicios.ilab.ecommerce.pgsql.dao.ProdutoDAO;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Departamento;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Produto;
import br.com.exercicios.ilab.ecommerce.pgsql.util.Mensagem;

@RestController
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;

	@GetMapping("/produtos")
	public List<Produto> recuperarTodos() {
		List<Produto> lista;
		lista = (List<Produto>) dao.recuperarTudaoComUmaUnicaQuery();
		return lista;
	}

	@GetMapping("/produtos/{id}")
	public ResponseEntity<?> recuperarPeloId(@PathVariable Integer id) {
		Produto res = dao.findById(id).orElse(null);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404).body(new Mensagem(12345, "Não encontrado!"));
//		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/produtos/busca")
	public ResponseEntity<?> recuperarPeloId(@RequestParam(name = "chave") String chave) {
		List<Produto> res = dao.findByNomeContainingOrDescricaoContaining(chave, chave);
		if (res.size() != 0) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/produtos/departamento/{id}")
	public List<Produto> recuperarPorDepartamento(@PathVariable Integer id) {
		Departamento d = new Departamento();
		d.setNumero(id);
		return dao.findByDpto(d);
	}
}
