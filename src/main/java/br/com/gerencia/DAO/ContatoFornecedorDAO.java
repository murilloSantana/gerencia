package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.ContatoFornecedor;

public interface ContatoFornecedorDAO {

	Boolean salvarContatoFornecedor(ContatoFornecedor contatoFornecedor);
	Boolean editarContatoFornecedor(ContatoFornecedor contatoFornecedor);
	Boolean excluirContatoFornecedor(ContatoFornecedor contatoFornecedor);
	Boolean exluirContatoFornecedorPorChave(Long chave);
	List<ContatoFornecedor> listarContatoFornecedors();
	List<ContatoFornecedor> pesquisarContatoFornecedorPorNome(String nomeAtributo, String valor);
	ContatoFornecedor pesquisarContatoFornecedorPorChave(Long chave);
}
