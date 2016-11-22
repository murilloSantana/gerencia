package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.TipoProdutoDAO;
import br.com.gerencia.model.TipoProduto;

@Service("tipoProdutoService")
public class TipoProdutoServiceImpl implements TipoProdutoService{

	@Autowired
	private TipoProdutoDAO tipoProdutoDAO;

	public Boolean salvarTipoProduto(TipoProduto tipoProduto) {
			return tipoProdutoDAO.salvarTipoProduto(tipoProduto);
		}

		public Boolean editarTipoProduto(TipoProduto tipoProduto) {
			return tipoProdutoDAO.editarTipoProduto(tipoProduto);
		}

		public Boolean excluirTipoProduto(TipoProduto tipoProduto) {
			return tipoProdutoDAO.excluirTipoProduto(tipoProduto);
		}

		public Boolean exluirTipoProdutoPorChave(Long chave) {
			return tipoProdutoDAO.exluirTipoProdutoPorChave(chave);
		}

		public List<TipoProduto> listarTipoProdutos() {
			return  tipoProdutoDAO.listarTipoProdutos();
		}

		public List<TipoProduto> pesquisarTipoProdutoPorNome(String nomeAtributo, String valor) {
			return  tipoProdutoDAO.pesquisarTipoProdutoPorNome(nomeAtributo, valor);
		}

		public TipoProduto pesquisarTipoProdutoPorChave(Long chave) {
			return tipoProdutoDAO.pesquisarTipoProdutoPorChave(chave);
		}
}
