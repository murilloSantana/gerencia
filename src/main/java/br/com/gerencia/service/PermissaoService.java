package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.Permissao;

public interface PermissaoService {

	Boolean salvarPermissao(Permissao permissao);
	Boolean editarPermissao(Permissao permissao);
	Boolean excluirPermissao(Permissao permissao);
	Boolean exluirPermissaoPorChave(Long chave);
	List<Permissao> listarPermissaos();
	List<Permissao> pesquisarPermissaoPorNome(String nomeAtributo, String valor);
	Permissao pesquisarPermissaoPorChave(Long chave);
}
