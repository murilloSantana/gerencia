package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Permissao;

public interface PermissaoDAO {

	Boolean salvarPermissao(Permissao permissao);
	Boolean editarPermissao(Permissao permissao);
	Boolean excluirPermissao(Permissao permissao);
	Boolean exluirPermissaoPorChave(Long chave);
	List<Permissao> listarPermissaos();
	List<Permissao> pesquisarPermissaoPorNome(String nomeAtributo, String valor);
	Permissao pesquisarPermissaoPorChave(Long chave);
}
