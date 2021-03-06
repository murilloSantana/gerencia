package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.ContaUsuario;

public interface ContaUsuarioService {

	Boolean salvarConta(ContaUsuario conta);
	Boolean editarConta(ContaUsuario conta);
	Boolean excluirConta(ContaUsuario conta);
	Boolean exluirContaPorChave(Long chave);
	List<ContaUsuario> listarContas();
	List<ContaUsuario> pesquisarContaPorNome(String nomeAtributo, String valor);
	ContaUsuario pesquisarContaPorChave(Long chave);
	ContaUsuario pesquisarConta(String username);
}
