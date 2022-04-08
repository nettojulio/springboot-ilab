package br.com.exercicios.ilab.ecommerce.pgsql.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@Column(name = "numero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero; // integer not null auto_increment primary key,

	@Column(name = "data")
	private LocalDate data; // date,

	@Column(name = "valor_bruto")
	private double valor_bruto; // double, ou BigDecimal

	@Column(name = "desconto")
	private double desconto; // double, ou BigDecimal

	@Column(name = "valorTotal")
	private double valorTotal; // double, ou BigDecimal

	@ManyToOne
	@JoinColumn(name = "num_cliente")
	@JsonIgnoreProperties("listaPedido")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<ItemPedido> itens;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor_bruto() {
		return valor_bruto;
	}

	public void setValor_bruto(double valor_bruto) {
		this.valor_bruto = valor_bruto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValor_total() {
		return valorTotal;
	}

	public void setValor_total(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
}
