package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.TipoTransacao;
@Repository("tipoTransacaoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TipoTransacaoDAOImpl extends AbstractDAO<Long, TipoTransacao> implements TipoTransacaoDAO{

	public Boolean salvarTipoTransacao(TipoTransacao tipoTransacao) {
		return super.salvar(tipoTransacao);
	}

	public Boolean editarTipoTransacao(TipoTransacao tipoTransacao) {
		return super.editar(tipoTransacao);
	}

	public Boolean excluirTipoTransacao(TipoTransacao tipoTransacao) {
		return super.excluir(tipoTransacao);
	}

	public Boolean exluirTipoTransacaoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<TipoTransacao> listarTipoTransacaos() {
		return (List<TipoTransacao>) super.listarTodos();
	}

	public List<TipoTransacao> pesquisarTipoTransacaoPorNome(String nomeAtributo, String valor) {
		return (List<TipoTransacao>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public TipoTransacao pesquisarTipoTransacaoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
