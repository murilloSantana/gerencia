package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.CondicaoPagamento;

@Repository("condicaoPagamentoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class CondicaoPagamentoDAOImpl extends AbstractDAO<Long, CondicaoPagamento> implements CondicaoPagamentoDAO{

	public Boolean salvarCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		return super.salvar(condicaoPagamento);
	}

	public Boolean editarCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		return super.editar(condicaoPagamento);
	}

	public Boolean excluirCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		return super.excluir(condicaoPagamento);
	}

	public Boolean exluirCondicaoPagamentoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<CondicaoPagamento> listarCondicaoPagamentos() {
		return (List<CondicaoPagamento>) super.listarTodos();
	}

	public List<CondicaoPagamento> pesquisarCondicaoPagamentoPorNome(String nomeAtributo, String valor) {
		return (List<CondicaoPagamento>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public CondicaoPagamento pesquisarCondicaoPagamentoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
