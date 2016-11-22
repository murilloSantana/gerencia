package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.ItemTransacao;

public interface ItemTransacaoService {

	Boolean salvarItemTransacao(ItemTransacao itemTransacao);
	Boolean editarItemTransacao(ItemTransacao itemTransacao);
	Boolean excluirItemTransacao(ItemTransacao itemTransacao);
	Boolean exluirItemTransacaoPorChave(Long chave);
	List<ItemTransacao> listarItemTransacaos();
	List<ItemTransacao> pesquisarItemTransacaoPorNome(String nomeAtributo, String valor);
	ItemTransacao pesquisarItemTransacaoPorChave(Long chave);
}
