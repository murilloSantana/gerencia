package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.TipoFornecedor;

public interface TipoFornecedorService {

	Boolean salvarTipoFornecedor(TipoFornecedor tipoFornecedor);
	Boolean editarTipoFornecedor(TipoFornecedor tipoFornecedor);
	Boolean excluirTipoFornecedor(TipoFornecedor tipoFornecedor);
	Boolean exluirTipoFornecedorPorChave(Long chave);
	List<TipoFornecedor> listarTipoFornecedors();
	List<TipoFornecedor> pesquisarTipoFornecedorPorNome(String nomeAtributo, String valor);
	TipoFornecedor pesquisarTipoFornecedorPorChave(Long chave);
}
