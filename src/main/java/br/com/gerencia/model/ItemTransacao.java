package br.com.gerencia.model;

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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
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
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime data;
	@Column(name = "hora_inicio")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime horaInicio;
	@Column(name = "hora_fim")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime horaFim;

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
	private String modelo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maquina_id")
	private Maquina maquina;

	public ItemTransacao() {
		super();
	}

	public ItemTransacao(Long chaveItemTransacao, Double precoUnitario, LocalDateTime data, LocalDateTime horaInicio,
			LocalDateTime horaFim, Transacao transacao, Produto produto, Integer minuto, String modelo,
			Maquina maquina) {
		super();
		this.chaveItemTransacao = chaveItemTransacao;
		this.precoUnitario = precoUnitario;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.transacao = transacao;
		this.produto = produto;
		this.minuto = minuto;
		this.modelo = modelo;
		this.maquina = maquina;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalDateTime horaFim) {
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
