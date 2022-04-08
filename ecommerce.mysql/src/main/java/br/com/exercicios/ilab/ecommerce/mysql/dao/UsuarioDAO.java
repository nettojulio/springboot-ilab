package br.com.exercicios.ilab.ecommerce.mysql.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.exercicios.ilab.ecommerce.mysql.model.Usuario;

public interface UsuarioDAO extends CrudRepository <Usuario, Integer>{
	public Usuario findByUsernameOrEmail(String username, String email);
}