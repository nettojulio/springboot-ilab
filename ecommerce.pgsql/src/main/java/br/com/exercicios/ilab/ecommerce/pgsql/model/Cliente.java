package br.com.exercicios.ilab.ecommerce.pgsql.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero; // integer not null auto_increment primary key,

	@Column(name = "nome", length = 100, nullable = false)
	private String nome; // varchar(100) not null,

	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf; // varchar(11) not null unique,

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email; // varchar(50) not null unique,

	@Column(name = "telefone", nullable = false)
	private int telefone; // integer not null,

	@Column(name = "logradouro", length = 50, nullable = false)
	private String logradouro; // varchar(50) not null ,

	@Column(name = "num_res")
	private int num_res; // integer,

	@Column(name = "compl", length = 30)
	private String compl; // varchar(30),

	@Column(name = "bairro", length = 30)
	private String bairro; // varchar(30),

	@Column(name = "cidade", length = 30)
	private String cidade; // varchar(30),

	@Column(name = "estado", length = 2, nullable = false)
	private String estado; // char(2) not null,

	@Column(name = "cep", length = 8)
	private String cep; // char(8)

	@OneToMany(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private List<Pedido> listaPedido;

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNum_res() {
		return num_res;
	}

	public void setNum_res(int num_res) {
		this.num_res = num_res;
	}

	public String getCompl() {
		return compl;
	}

	public void setCompl(String compl) {
		this.compl = compl;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
