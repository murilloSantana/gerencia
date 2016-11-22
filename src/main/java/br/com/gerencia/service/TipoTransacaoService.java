package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.TipoTransacao;

public interface TipoTransacaoService {

	Boolean salvarTipoTransacao(TipoTransacao tipoTransacao);
	Boolean editarTipoTransacao(TipoTransacao tipoTransacao);
	Boolean excluirTipoTransacao(TipoTransacao tipoTransacao);
	Boolean exluirTipoTransacaoPorChave(Long chave);
	List<TipoTransacao> listarTipoTransacaos();
	List<TipoTransacao> pesquisarTipoTransacaoPorNome(String nomeAtributo, String valor);
	TipoTransacao pesquisarTipoTransacaoPorChave(Long chave);
}
