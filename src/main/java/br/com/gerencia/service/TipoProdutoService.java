package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.TipoProduto;

public interface TipoProdutoService {

	Boolean salvarTipoProduto(TipoProduto tipoProduto);
	Boolean editarTipoProduto(TipoProduto tipoProduto);
	Boolean excluirTipoProduto(TipoProduto tipoProduto);
	Boolean exluirTipoProdutoPorChave(Long chave);
	List<TipoProduto> listarTipoProdutos();
	List<TipoProduto> pesquisarTipoProdutoPorNome(String nomeAtributo, String valor);
	TipoProduto pesquisarTipoProdutoPorChave(Long chave);
}
