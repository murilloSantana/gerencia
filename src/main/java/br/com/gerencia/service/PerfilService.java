package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.Perfil;

public interface PerfilService {

	Boolean salvarPerfil(Perfil perfil);
	Boolean editarPerfil(Perfil perfil);
	Boolean excluirPerfil(Perfil perfil);
	Boolean exluirPerfilPorChave(Long chave);
	List<Perfil> listarPerfils();
	List<Perfil> pesquisarPerfilPorNome(String nomeAtributo, String valor);
	Perfil pesquisarPerfilPorChave(Long chave);
}
