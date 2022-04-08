package br.com.exercicios.ilab.ecommerce.pgsql.services;

import java.util.List;

import br.com.exercicios.ilab.ecommerce.pgsql.dto.UsuarioLoginDTO;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Usuario;
import br.com.exercicios.ilab.ecommerce.pgsql.security.Token;

public interface IUsuarioService {
	public Token gerarTokenDeUsuarioLogado(UsuarioLoginDTO dadosLogin);
	public Usuario adicionarUsuario(Usuario novo);
	public Usuario atualizarUsuario(Usuario atualizar);
	public List<Usuario> recuperarTodos();
	public Usuario recuperarDetalhes(Integer id);

}