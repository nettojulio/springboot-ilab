package br.com.exercicios.ilab.ecommerce.pgsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.exercicios.ilab.ecommerce.pgsql.dao.UsuarioDAO;
import br.com.exercicios.ilab.ecommerce.pgsql.dto.UsuarioLoginDTO;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Usuario;
import br.com.exercicios.ilab.ecommerce.pgsql.security.EcommerceCrypto;
import br.com.exercicios.ilab.ecommerce.pgsql.security.Token;
import br.com.exercicios.ilab.ecommerce.pgsql.security.TokenUtil;

@Component
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuarioDAO dao;

	@Override
	public Token gerarTokenDeUsuarioLogado(UsuarioLoginDTO dadosLogin) {
		Usuario user = dao.findByUsernameOrEmail(dadosLogin.getUsername(), dadosLogin.getEmail());
		try {
			if (user != null) {

				String senhaLogin = EcommerceCrypto.encrypt(dadosLogin.getSenha());

				if (user.getSenha().equals(dadosLogin.getSenha())) {
					atualizarUsuario(user);
				}

				if (senhaLogin.equals(user.getSenha())) {
					return new Token(TokenUtil.createToken(user));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public Usuario adicionarUsuario(Usuario novo) {
		try {
			if (novo.getSenha() != null) {
				novo.setSenha(EcommerceCrypto.encrypt(novo.getSenha()));
				dao.save(novo);
				return novo;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario atualizarUsuario(Usuario atualizar) {
		try {
			if (atualizar.getSenha() != null) {
				atualizar.setSenha(EcommerceCrypto.encrypt(atualizar.getSenha()));
				dao.save(atualizar);
				return atualizar;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Usuario> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Usuario>) dao.findAll();
	}

	@Override
	public Usuario recuperarDetalhes(Integer id) {
		// TODO Auto-generated method stub
		try {
			if (id <= 0)
				throw new RuntimeException("ID invalido para consulta");
			return dao.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new RuntimeException(ex.toString() + " - "+ex.getMessage());
		}
	}

}
