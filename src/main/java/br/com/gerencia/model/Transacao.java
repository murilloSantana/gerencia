package br.com.gerencia.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Transacao {
	@Id
	@GeneratedValue(generator = "transacao_seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "transacao_seq", sequenceName = "chave_transacao_seq", allocationSize = 1)
	@Column(name = "chave_transacao")
	private Long chaveTransacao;
	@Column(name = "data_transacao")
	private Date dataTransacao;
	@Column
	private String observacao;
	@Column(name = "valor_total")
	private Double valorTotal;
	@Column
	private Boolean isCancelada;
	@Column(name = "motivo_cancelamento")
	private String motivoCancelamento;

	// private TipoTransacao tipoTransacao;

	// private ContaUsuario conta;

	// private CupomDesconto cupomDesconto;

	// private FormasPagamento[] formasPagamento;
	@Column
	private Boolean isAndamento;

	// private TipoConta tipoConta;

	// private Cliente cliente;

	// private Funcionario funcionario;

	@OneToMany(mappedBy = "transacao", targetEntity = ItemTransacao.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ItemTransacao> itensTransacao;

	public Transacao() {
		super();
	}

	public Transacao(Long chaveTransacao, Date dataTransacao, String observacao, Double valorTotal, Boolean isCancelada,
			String motivoCancelamento, Boolean isAndamento, List<ItemTransacao> itensTransacao) {
		super();
		this.chaveTransacao = chaveTransacao;
		this.dataTransacao = dataTransacao;
		this.observacao = observacao;
		this.valorTotal = valorTotal;
		this.isCancelada = isCancelada;
		this.motivoCancelamento = motivoCancelamento;
		this.isAndamento = isAndamento;
		this.itensTransacao = itensTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Boolean getIsCancelada() {
		return isCancelada;
	}

	public void setIsCancelada(Boolean isCancelada) {
		this.isCancelada = isCancelada;
	}

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

	public Boolean getIsAndamento() {
		return isAndamento;
	}

	public void setIsAndamento(Boolean isAndamento) {
		this.isAndamento = isAndamento;
	}

	public Long getChaveTransacao() {
		return chaveTransacao;
	}

}
