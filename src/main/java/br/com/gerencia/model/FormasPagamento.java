package br.com.gerencia.model;

public class FormasPagamento {

	private Long chaveFormaPagamento;

	private String descricao;

	private int numeroParcelas;

	private Double juros;

	private Double valorPagamento;

	private CondicaoPagamento condicaoPagamento;

	private Transacao[] transacoes;

}
