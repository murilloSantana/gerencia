
package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Categoria;

@Repository("categoriaDAO")
@Transactional
@SuppressWarnings("unchecked")
public class CategoriaDAOImpl extends AbstractDAO<Long, Categoria> implements CategoriaDAO{
	
	public Boolean salvarCategoria(Categoria categoria) {
		return super.salvar(categoria);
	}

	public Boolean editarCategoria(Categoria categoria) {
		return super.editar(categoria);
	}

	public Boolean excluirCategoria(Categoria categoria) {
		return super.excluir(categoria);
	}

	public Boolean exluirCategoriaPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Categoria> listarCategorias() {
		return (List<Categoria>) super.listarTodos();
	}

	public List<Categoria> pesquisarCategoriaPorNome(String nomeAtributo, String valor) {
		return (List<Categoria>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Categoria pesquisarCategoriaPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
