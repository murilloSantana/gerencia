package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.ProdutoEstoque;

public interface ProdutoEstoqueService {

	Boolean salvarProdutoEstoque(ProdutoEstoque produtoEstoque);
	Boolean editarProdutoEstoque(ProdutoEstoque produtoEstoque);
	Boolean excluirProdutoEstoque(ProdutoEstoque produtoEstoque);
	Boolean exluirProdutoEstoquePorChave(Long chave);
	List<ProdutoEstoque> listarProdutoEstoques();
	List<ProdutoEstoque> pesquisarProdutoEstoquePorNome(String nomeAtributo, String valor);
	ProdutoEstoque pesquisarProdutoEstoquePorChave(Long chave);
}
