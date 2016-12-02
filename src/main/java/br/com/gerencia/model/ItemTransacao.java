package br.com.gerencia.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.com.gerencia.model.loja.Maquina;

@Entity
@Table(name = "item_transacao")
@Component
public class ItemTransacao {
	@Id
	@GeneratedValue(generator = "item_transacao_seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "item_transacao_seq", sequenceName = "chave_item_transacao_seq", allocationSize = 1)
	@Column(name = "chave_item_transacao")
	private Long chaveItemTransacao;
	@Column(name = "preco_unitario")
	private Double precoUnitario;
	@Column
	private Date data;
	@Column(name = "hora_inicio")
	private Date horaInicio;
	@Column(name = "hora_fim")
	private Date horaFim;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transacao_id")
	private Transacao transacao;
	// @Column(name = "orcamento_venda")
	// private OrcamentoVenda orcamentoVenda;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id")
	private Produto produto;
	@Column
	private Integer minuto;
	@Column
	private Double preco;
	@Column
	private String modelo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;

	public ItemTransacao() {
		super();
	}

	public ItemTransacao(Long chaveItemTransacao, Double precoUnitario, Date data, Date horaInicio, Date horaFim,
			Transacao transacao, Produto produto, Integer minuto, Double preco, String modelo, Maquina maquina) {
		super();
		this.chaveItemTransacao = chaveItemTransacao;
		this.precoUnitario = precoUnitario;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.transacao = transacao;
		this.produto = produto;
		this.minuto = minuto;
		this.preco = preco;
		this.modelo = modelo;
		this.maquina = maquina;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getChaveItemTransacao() {
		return chaveItemTransacao;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

}
