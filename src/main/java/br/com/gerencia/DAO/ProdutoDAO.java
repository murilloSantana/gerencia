package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Produto;

public interface ProdutoDAO {

	Boolean salvarProduto(Produto produto);
	Boolean editarProduto(Produto produto);
	Boolean excluirProduto(Produto produto);
	Boolean exluirProdutoPorChave(Long chave);
	List<Produto> listarProdutos();
	List<Produto> pesquisarProdutoPorNome(String nomeAtributo, String valor);
	Produto pesquisarProdutoPorChave(Long chave);
}
