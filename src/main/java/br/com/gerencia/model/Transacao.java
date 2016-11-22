package br.com.gerencia.model;

import java.util.Date;

public class Transacao {

	private Long chaveTransacao;

	private Date dataTransacao;

	private String observacao;

	private Double valorTotal;

	private Boolean isCancelada;

	private String motivoCancelamento;

	private TipoTransacao tipoTransacao;

	private ContaUsuario conta;

	private CupomDesconto cupomDesconto;

	private FormasPagamento[] formasPagamento;

	private Boolean isAndamento;

	private TipoConta tipoConta;

	private Cliente cliente;
	
	private Funcionario funcionario;
}
