package br.com.exercicios.ilab.ecommerce.pgsql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exercicios.ilab.ecommerce.pgsql.dto.UsuarioLoginDTO;
import br.com.exercicios.ilab.ecommerce.pgsql.security.Token;
import br.com.exercicios.ilab.ecommerce.pgsql.services.IUsuarioService;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private IUsuarioService service;

	@PostMapping("/login")
	public ResponseEntity<Token> realizarLogin(@RequestBody UsuarioLoginDTO dadosLogin) {
		Token token = service.gerarTokenDeUsuarioLogado(dadosLogin);
		if (token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(401).build();
	}

}
