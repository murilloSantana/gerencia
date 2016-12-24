package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.Produto;

@Repository("produtoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ProdutoDAOImpl extends AbstractDAO<Long, Produto> implements
		ProdutoDAO {

	public Boolean salvarProduto(Produto produto) {
		return super.salvar(produto);
	}

	public Boolean editarProduto(Produto produto) {
		return super.editar(produto);
	}

	public Boolean excluirProduto(Produto produto) {
		return super.excluir(produto);
	}

	public Boolean exluirProdutoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Produto> listarProdutos() {
		return (List<Produto>) super.listarTodos();
	}

	public List<Produto> pesquisarProdutoPorNome(String nomeAtributo,
			String valor) {
		return (List<Produto>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Produto pesquisarProdutoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}

	public List<Produto> listarProdutosSemCategoria() {
		SQLQuery query = getSession().createSQLQuery("select * from produto");
		query.addEntity(Produto.class);
		List<Produto> produtos = query.list();
		for (Produto produto : produtos) {
			produto.setCategorias(null);
		}
		return produtos;
	}

}
