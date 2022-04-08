package br.com.exercicios.ilab.ecommerce.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo; // integer not null auto_increment primary key,

	@Column(name = "nome", length = 50, nullable = false)
	private String nome; // varchar(50) not null,

	@Column(name = "descricao", columnDefinition = "TEXT") // ou length = 16384
	private String descricao; // text,

	@Column(name = "preco")
	private double preco; // double, ou BigDecimal

	@Column(name = "qtdEstoque")
	private int qtdEstoque; // integer,

	@Column(name = "linkFoto", length = 255)
	private String linkFoto; // varchar(255),

	@ManyToOne
	@JoinColumn(name = "num_depto")
	@JsonIgnoreProperties("listaProdutos")
	private Departamento dpto;

	public Produto() {
		// nao faz nadica de nada!!!
	}

	public Produto(Integer codigo, String nome, String descricao, Double preco, Integer qtdEstoque, String linkFoto,
			Integer numeroDpto, String nomeDpto, Integer andarDpto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
		this.linkFoto = linkFoto;
		this.dpto = new Departamento();
		this.dpto.setNumero(numeroDpto);
		this.dpto.setNome(nomeDpto);
		this.dpto.setAndar(andarDpto);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public Departamento getDpto() {
		return dpto;
	}

	public void setDpto(Departamento dpto) {
		this.dpto = dpto;
	}

}
