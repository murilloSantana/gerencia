package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.ProdutoEstoque;

@Repository("produtoEstoqueDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ProdutoEstoqueDAOImpl extends AbstractDAO<Long, ProdutoEstoque> implements ProdutoEstoqueDAO{

	public Boolean salvarProdutoEstoque(ProdutoEstoque produtoEstoque) {
		return super.salvar(produtoEstoque);
	}

	public Boolean editarProdutoEstoque(ProdutoEstoque produtoEstoque) {
		return super.editar(produtoEstoque);
	}

	public Boolean excluirProdutoEstoque(ProdutoEstoque produtoEstoque) {
		return super.excluir(produtoEstoque);
	}

	public Boolean exluirProdutoEstoquePorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<ProdutoEstoque> listarProdutosEstoque() {
		return (List<ProdutoEstoque>) super.listarTodos();
	}

	public List<ProdutoEstoque> pesquisarProdutoEstoquePorNome(
			String nomeAtributo, String valor) {
		return (List<ProdutoEstoque>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public ProdutoEstoque pesquisarProdutoEstoquePorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}

}
