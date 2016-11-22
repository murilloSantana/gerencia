package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.CondicaoPagamento;

public interface CondicaoPagamentoDAO {

	Boolean salvarCondicaoPagamento(CondicaoPagamento condicaoPagamento);
	Boolean editarCondicaoPagamento(CondicaoPagamento condicaoPagamento);
	Boolean excluirCondicaoPagamento(CondicaoPagamento condicaoPagamento);
	Boolean exluirCondicaoPagamentoPorChave(Long chave);
	List<CondicaoPagamento> listarCondicaoPagamentos();
	List<CondicaoPagamento> pesquisarCondicaoPagamentoPorNome(String nomeAtributo, String valor);
	CondicaoPagamento pesquisarCondicaoPagamentoPorChave(Long chave);
}
