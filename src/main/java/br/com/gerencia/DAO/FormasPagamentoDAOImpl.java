package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.FormasPagamento;

@Repository("formasPagamentoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class FormasPagamentoDAOImpl extends AbstractDAO<Long, FormasPagamento> implements FormasPagamentoDAO{

	public Boolean salvarFormasPagamento(FormasPagamento formasPagamento) {
		return super.salvar(formasPagamento);
	}

	public Boolean editarFormasPagamento(FormasPagamento formasPagamento) {
		return super.editar(formasPagamento);
	}

	public Boolean excluirFormasPagamento(FormasPagamento formasPagamento) {
		return super.excluir(formasPagamento);
	}

	public Boolean exluirFormasPagamentoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<FormasPagamento> listarFormasPagamentos() {
		return (List<FormasPagamento>) super.listarTodos();
	}

	public List<FormasPagamento> pesquisarFormasPagamentoPorNome(String nomeAtributo, String valor) {
		return (List<FormasPagamento>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public FormasPagamento pesquisarFormasPagamentoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
