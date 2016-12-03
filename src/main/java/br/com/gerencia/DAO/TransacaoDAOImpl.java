package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Transacao;

@Repository("transacaoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TransacaoDAOImpl extends AbstractDAO<Long, Transacao> implements TransacaoDAO {

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

	public List<Transacao> transacoesAtivas() {
		SQLQuery query = getSession()
				.createSQLQuery("SELECT DISTINCT tr.* " + "FROM transacao tr " + "INNER JOIN item_transacao it "
						+ "ON tr.chave_transacao = it.chave_item_transacao " + "WHERE isativa = true ");
		query.addEntity(Transacao.class);
		List<Transacao> transacoes = query.list();

		return transacoes;
	}

	public Boolean isTransacaoAtiva(Integer numeroMaquina) {
		try {

			SQLQuery query = getSession().createSQLQuery("SELECT tr.* " + "FROM item_transacao it "
					+ "INNER JOIN transacao tr " + "ON it.chave_item_transacao = tr.chave_transacao "
					+ "INNER JOIN maquina m " + "ON it.maquina_id = m.chavemaquina " + "WHERE tr.isativa = true "
					+ "AND m.numero = :numeroMaquina");
			query.setParameter("numeroMaquina", numeroMaquina);
			query.addEntity(Transacao.class);

			List<Transacao> transacoes = query.list();

			return transacoes.size() > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}

	}
}
