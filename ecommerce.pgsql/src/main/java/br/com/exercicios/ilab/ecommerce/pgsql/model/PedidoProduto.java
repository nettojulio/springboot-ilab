package br.com.exercicios.ilab.ecommerce.pgsql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto {

	@Id
	@Column(name = "num_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num_seq; // integer not null auto_increment primary key,

//	@Column(name = "cod_produto", nullable = false)
//	private int cod_produto; // integer not null,

//	@Column(name = "num_pedido", nullable = false)
//	private int num_pedido; // integer not null,

	@Column(name = "quantidade")
	private int quantidade; // integer,

	@Column(name = "preco_unit")
	private double preco_unit; // double, ou BigDecimal

	@Column(name = "preco_total")
	private double preco_total; // double, ou BigDecimal

	public int getNum_seq() {
		return num_seq;
	}

	public void setNum_seq(int num_seq) {
		this.num_seq = num_seq;
	}

//	public int getCod_produto() {
//		return cod_produto;
//	}
//
//	public void setCod_produto(int cod_produto) {
//		this.cod_produto = cod_produto;
//	}
//
//	public int getNum_pedido() {
//		return num_pedido;
//	}
//
//	public void setNum_pedido(int num_pedido) {
//		this.num_pedido = num_pedido;
//	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco_unit() {
		return preco_unit;
	}

	public void setPreco_unit(double preco_unit) {
		this.preco_unit = preco_unit;
	}

	public double getPreco_total() {
		return preco_total;
	}

	public void setPreco_total(double preco_total) {
		this.preco_total = preco_total;
	}

}
