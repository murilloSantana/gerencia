package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.FormasPagamento;

public interface FormasPagamentoDAO {

	Boolean salvarFormasPagamento(FormasPagamento formasPagamento);
	Boolean editarFormasPagamento(FormasPagamento formasPagamento);
	Boolean excluirFormasPagamento(FormasPagamento formasPagamento);
	Boolean exluirFormasPagamentoPorChave(Long chave);
	List<FormasPagamento> listarFormasPagamentos();
	List<FormasPagamento> pesquisarFormasPagamentoPorNome(String nomeAtributo, String valor);
	FormasPagamento pesquisarFormasPagamentoPorChave(Long chave);
}
