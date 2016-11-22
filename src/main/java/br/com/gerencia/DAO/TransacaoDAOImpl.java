package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Transacao;
@Repository("transacaoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TransacaoDAOImpl extends AbstractDAO<Long, Transacao> implements TransacaoDAO{

	public Boolean salvarTransacao(Transacao transacao) {
		return super.salvar(transacao);
	}

	public Boolean editarTransacao(Transacao transacao) {
		return super.editar(transacao);
	}

	public Boolean excluirTransacao(Transacao transacao) {
		return super.excluir(transacao);
	}

	public Boolean exluirTransacaoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Transacao> listarTransacaos() {
		return (List<Transacao>) super.listarTodos();
	}

	public List<Transacao> pesquisarTransacaoPorNome(String nomeAtributo, String valor) {
		return (List<Transacao>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Transacao pesquisarTransacaoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
