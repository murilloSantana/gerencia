package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.TempoGuardado;

public interface TempoGuardadoService {

	Boolean salvarTempoGuardado(TempoGuardado tempoGuardado);
	Boolean editarTempoGuardado(TempoGuardado tempoGuardado);
	Boolean excluirTempoGuardado(TempoGuardado tempoGuardado);
	Boolean exluirTempoGuardadoPorChave(Long chave);
	List<TempoGuardado> listarTempoGuardados();
	List<TempoGuardado> pesquisarTempoGuardadoPorNome(String nomeAtributo, String valor);
	TempoGuardado pesquisarTempoGuardadoPorChave(Long chave);
}
