package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.TipoProduto;
@Repository("tipoProdutoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TipoProdutoDAOImpl extends AbstractDAO<Long, TipoProduto> implements TipoProdutoDAO{

	public Boolean salvarTipoProduto(TipoProduto tipoProduto) {
		return super.salvar(tipoProduto);
	}

	public Boolean editarTipoProduto(TipoProduto tipoProduto) {
		return super.editar(tipoProduto);
	}

	public Boolean excluirTipoProduto(TipoProduto tipoProduto) {
		return super.excluir(tipoProduto);
	}

	public Boolean exluirTipoProdutoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<TipoProduto> listarTipoProdutos() {
		return (List<TipoProduto>) super.listarTodos();
	}

	public List<TipoProduto> pesquisarTipoProdutoPorNome(String nomeAtributo, String valor) {
		return (List<TipoProduto>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public TipoProduto pesquisarTipoProdutoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}

}
