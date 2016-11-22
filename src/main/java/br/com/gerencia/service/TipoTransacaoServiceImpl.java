package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.TipoTransacaoDAO;
import br.com.gerencia.model.TipoTransacao;

@Service("tipoTransacaoService")
public class TipoTransacaoServiceImpl implements TipoTransacaoService{

	@Autowired
	private TipoTransacaoDAO tipoTransacaoDAO;

	public Boolean salvarTipoTransacao(TipoTransacao tipoTransacao) {
			return tipoTransacaoDAO.salvarTipoTransacao(tipoTransacao);
		}

		public Boolean editarTipoTransacao(TipoTransacao tipoTransacao) {
			return tipoTransacaoDAO.editarTipoTransacao(tipoTransacao);
		}

		public Boolean excluirTipoTransacao(TipoTransacao tipoTransacao) {
			return tipoTransacaoDAO.excluirTipoTransacao(tipoTransacao);
		}

		public Boolean exluirTipoTransacaoPorChave(Long chave) {
			return tipoTransacaoDAO.exluirTipoTransacaoPorChave(chave);
		}

		public List<TipoTransacao> listarTipoTransacaos() {
			return  tipoTransacaoDAO.listarTipoTransacaos();
		}

		public List<TipoTransacao> pesquisarTipoTransacaoPorNome(String nomeAtributo, String valor) {
			return  tipoTransacaoDAO.pesquisarTipoTransacaoPorNome(nomeAtributo, valor);
		}

		public TipoTransacao pesquisarTipoTransacaoPorChave(Long chave) {
			return tipoTransacaoDAO.pesquisarTipoTransacaoPorChave(chave);
		}
}
