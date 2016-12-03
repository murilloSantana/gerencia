package br.com.gerencia.model;

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

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
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
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dataTransacao;
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
	private Boolean isAtiva;

	// private TipoConta tipoConta;

	// private Cliente cliente;

	// private Funcionario funcionario;

	@OneToMany(mappedBy = "transacao", targetEntity = ItemTransacao.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<ItemTransacao> itensTransacao;

	public Transacao() {
		super();
	}

	public Transacao(LocalDateTime dataTransacao, String observacao, Double valorTotal, Boolean isCancelada,
			String motivoCancelamento, Boolean isAndamento, List<ItemTransacao> itensTransacao) {
		super();
		this.dataTransacao = dataTransacao;
		this.observacao = observacao;
		this.valorTotal = valorTotal;
		this.isCancelada = isCancelada;
		this.motivoCancelamento = motivoCancelamento;
		this.isAtiva = isAndamento;
		this.itensTransacao = itensTransacao;
	}

	public LocalDateTime getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDateTime dataTransacao) {
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
		return isAtiva;
	}

	public void setIsAndamento(Boolean isAndamento) {
		this.isAtiva = isAndamento;
	}

	public Long getChaveTransacao() {
		return chaveTransacao;
	}

	public Boolean getIsAtiva() {
		return isAtiva;
	}

	public void setIsAtiva(Boolean isAtiva) {
		this.isAtiva = isAtiva;
	}

	public List<ItemTransacao> getItensTransacao() {
		return itensTransacao;
	}

	public void setItensTransacao(List<ItemTransacao> itensTransacao) {
		this.itensTransacao = itensTransacao;
	}

}
