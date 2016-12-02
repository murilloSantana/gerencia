package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.InformacoesTecnicas;

public interface InformacoesTecnicasDAO {

	InformacoesTecnicas salvarInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas);
	Boolean editarInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas);
	Boolean excluirInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas);
	Boolean exluirInformacoesTecnicasPorChave(Long chave);
	List<InformacoesTecnicas> listarInformacoesTecnicass();
	List<InformacoesTecnicas> pesquisarInformacoesTecnicasPorNome(String nomeAtributo, String valor);
	InformacoesTecnicas pesquisarInformacoesTecnicasPorChave(Long chave);
}
