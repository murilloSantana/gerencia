package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.ProdutoDAO;
import br.com.gerencia.model.Produto;
@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoDAO produtoDAO;

	public Boolean salvarProduto(Produto produto) {
			return produtoDAO.salvarProduto(produto);
		}

		public Boolean editarProduto(Produto produto) {
			return produtoDAO.editarProduto(produto);
		}

		public Boolean excluirProduto(Produto produto) {
			return produtoDAO.excluirProduto(produto);
		}

		public Boolean exluirProdutoPorChave(Long chave) {
			return produtoDAO.exluirProdutoPorChave(chave);
		}

		public List<Produto> listarProdutos() {
			return  produtoDAO.listarProdutos();
		}

		public List<Produto> pesquisarProdutoPorNome(String nomeAtributo, String valor) {
			return  produtoDAO.pesquisarProdutoPorNome(nomeAtributo, valor);
		}

		public Produto pesquisarProdutoPorChave(Long chave) {
			return produtoDAO.pesquisarProdutoPorChave(chave);
		}
}
