package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Categoria;

public interface CategoriaDAO {

	Boolean salvarCategoria(Categoria categoria);
	Boolean editarCategoria(Categoria categoria);
	Boolean excluirCategoria(Categoria categoria);
	Boolean exluirCategoriaPorChave(Long chave);
	List<Categoria> listarCategorias();
	List<Categoria> pesquisarCategoriaPorNome(String nomeAtributo, String valor);
	Categoria pesquisarCategoriaPorChave(Long chave);
}
