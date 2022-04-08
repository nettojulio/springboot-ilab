package br.com.exercicios.ilab.ecommerce.pgsql.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import br.com.exercicios.ilab.ecommerce.pgsql.dao.ClienteDAO;
import br.com.exercicios.ilab.ecommerce.pgsql.dto.ClienteDTO;
import br.com.exercicios.ilab.ecommerce.pgsql.model.Cliente;

@Component
@Primary
public class ClienteServiceImplAlternativa implements IClienteService{

	@Autowired
	private ClienteDAO dao;
	
	@Override
	public List<ClienteDTO> recuperarTodos() {
		System.out.println("estou no recuperar todos alternativo");
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		for (Cliente c: dao.findAll()) {
			lista.add(new ClienteDTO(c));  // uso a estratégia do construtor
		}		
		return lista;
	}

	@Override
	public ClienteDTO recuperarPeloId(Integer id) {
		System.out.println("Estou no recuperar pelo id alternativo");
		// TODO Auto-generated method stub
		Cliente res = dao.findById(id).orElse(null);
		if (res != null) {
			return ClienteDTO.fromCliente(res);  // aqui uso o "builder" estático
		}
		return null;
	}
	

}