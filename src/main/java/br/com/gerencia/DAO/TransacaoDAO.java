package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Transacao;

public interface TransacaoDAO {

	Boolean salvarTransacao(Transacao transacao);
	Boolean editarTransacao(Transacao transacao);
	Boolean excluirTransacao(Transacao transacao);
	Boolean exluirTransacaoPorChave(Long chave);
	List<Transacao> listarTransacaos();
	List<Transacao> pesquisarTransacaoPorNome(String nomeAtributo, String valor);
	Transacao pesquisarTransacaoPorChave(Long chave);
}
