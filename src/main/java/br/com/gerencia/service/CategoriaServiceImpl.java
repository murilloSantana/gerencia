package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.CategoriaDAO;
import br.com.gerencia.model.Categoria;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDAO categoriaDAO;

	public Boolean salvarCategoria(Categoria categoria) {
			return categoriaDAO.salvarCategoria(categoria);
		}

		public Boolean editarCategoria(Categoria categoria) {
			return categoriaDAO.editarCategoria(categoria);
		}

		public Boolean excluirCategoria(Categoria categoria) {
			return categoriaDAO.excluirCategoria(categoria);
		}

		public Boolean exluirCategoriaPorChave(Long chave) {
			return categoriaDAO.exluirCategoriaPorChave(chave);
		}

		public List<Categoria> listarCategorias() {
			return  categoriaDAO.listarCategorias();
		}

		public List<Categoria> pesquisarCategoriaPorNome(String nomeAtributo, String valor) {
			return (List<Categoria>) categoriaDAO.pesquisarCategoriaPorNome(nomeAtributo, valor);
		}

		public Categoria pesquisarCategoriaPorChave(Long chave) {
			return categoriaDAO.pesquisarCategoriaPorChave(chave);
		}
}
