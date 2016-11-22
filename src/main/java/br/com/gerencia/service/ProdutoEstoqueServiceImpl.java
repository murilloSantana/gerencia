package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.ProdutoEstoqueDAO;
import br.com.gerencia.model.ProdutoEstoque;

@Service("produtoEstoqueService")
public class ProdutoEstoqueServiceImpl implements ProdutoEstoqueService{

	@Autowired
	private ProdutoEstoqueDAO produtoEstoqueDAO;

	public Boolean salvarProdutoEstoque(ProdutoEstoque produtoEstoque) {
			return produtoEstoqueDAO.salvarProdutoEstoque(produtoEstoque);
		}

		public Boolean editarProdutoEstoque(ProdutoEstoque produtoEstoque) {
			return produtoEstoqueDAO.editarProdutoEstoque(produtoEstoque);
		}

		public Boolean excluirProdutoEstoque(ProdutoEstoque produtoEstoque) {
			return produtoEstoqueDAO.excluirProdutoEstoque(produtoEstoque);
		}

		public Boolean exluirProdutoEstoquePorChave(Long chave) {
			return produtoEstoqueDAO.exluirProdutoEstoquePorChave(chave);
		}

		public List<ProdutoEstoque> listarProdutoEstoques() {
			return  produtoEstoqueDAO.listarProdutosEstoque();
		}

		public List<ProdutoEstoque> pesquisarProdutoEstoquePorNome(String nomeAtributo, String valor) {
			return  produtoEstoqueDAO.pesquisarProdutoEstoquePorNome(nomeAtributo, valor);
		}

		public ProdutoEstoque pesquisarProdutoEstoquePorChave(Long chave) {
			return produtoEstoqueDAO.pesquisarProdutoEstoquePorChave(chave);
		}
}
