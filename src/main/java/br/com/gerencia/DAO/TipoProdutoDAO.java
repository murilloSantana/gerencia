package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.TipoProduto;

public interface TipoProdutoDAO {

	Boolean salvarTipoProduto(TipoProduto tipoProduto);
	Boolean editarTipoProduto(TipoProduto tipoProduto);
	Boolean excluirTipoProduto(TipoProduto TipoProduto);
	Boolean exluirTipoProdutoPorChave(Long chave);
	List<TipoProduto> listarTipoProdutos();
	List<TipoProduto> pesquisarTipoProdutoPorNome(String nomeAtributo, String valor);
	TipoProduto pesquisarTipoProdutoPorChave(Long chave);
}
