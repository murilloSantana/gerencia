package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.ProdutoEstoque;

public interface ProdutoEstoqueDAO {

	Boolean salvarProdutoEstoque(ProdutoEstoque produtoEstoque);
	Boolean editarProdutoEstoque(ProdutoEstoque produtoEstoque);
	Boolean excluirProdutoEstoque(ProdutoEstoque produtoEstoque);
	Boolean exluirProdutoEstoquePorChave(Long chave);
	List<ProdutoEstoque> listarProdutosEstoque();
	List<ProdutoEstoque> pesquisarProdutoEstoquePorNome(String nomeAtributo, String valor);
	ProdutoEstoque pesquisarProdutoEstoquePorChave(Long chave);
}
