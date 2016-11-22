package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.Fornecedor;

public interface FornecedorService {

	Boolean salvarFornecedor(Fornecedor fornecedor);
	Boolean editarFornecedor(Fornecedor fornecedor);
	Boolean excluirFornecedor(Fornecedor fornecedor);
	Boolean exluirFornecedorPorChave(Long chave);
	List<Fornecedor> listarFornecedors();
	List<Fornecedor> pesquisarFornecedorPorNome(String nomeAtributo, String valor);
	Fornecedor pesquisarFornecedorPorChave(Long chave);
}
