package br.com.gerencia.model;

import java.util.Date;

public class ItemTransacao {

	private Long chaveItemTransacao;

	private Double preco_unitario;

	private Date data;

	private Date hora_inicio;

	private Date hora_fim;

	private Transacao transacao;

	private OrcamentoVenda orcamentoVenda;

	private Produto produto;

}
