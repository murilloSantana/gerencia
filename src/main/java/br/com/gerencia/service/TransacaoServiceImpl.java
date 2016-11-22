package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.TransacaoDAO;
import br.com.gerencia.model.Transacao;

@Service("transacaoService")
public class TransacaoServiceImpl implements TransacaoService{

	@Autowired
	private TransacaoDAO transacaoDAO;

	public Boolean salvarTransacao(Transacao transacao) {
			return transacaoDAO.salvarTransacao(transacao);
		}

		public Boolean editarTransacao(Transacao transacao) {
			return transacaoDAO.editarTransacao(transacao);
		}

		public Boolean excluirTransacao(Transacao transacao) {
			return transacaoDAO.excluirTransacao(transacao);
		}

		public Boolean exluirTransacaoPorChave(Long chave) {
			return transacaoDAO.exluirTransacaoPorChave(chave);
		}

		public List<Transacao> listarTransacaos() {
			return  transacaoDAO.listarTransacaos();
		}

		public List<Transacao> pesquisarTransacaoPorNome(String nomeAtributo, String valor) {
			return  transacaoDAO.pesquisarTransacaoPorNome(nomeAtributo, valor);
		}

		public Transacao pesquisarTransacaoPorChave(Long chave) {
			return transacaoDAO.pesquisarTransacaoPorChave(chave);
		}
}
