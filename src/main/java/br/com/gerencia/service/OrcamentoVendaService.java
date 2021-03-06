package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.OrcamentoVenda;

public interface OrcamentoVendaService {

	Boolean salvarOrcamentoVenda(OrcamentoVenda orcamentoVenda);
	Boolean editarOrcamentoVenda(OrcamentoVenda orcamentoVenda);
	Boolean excluirOrcamentoVenda(OrcamentoVenda orcamentoVenda);
	Boolean exluirOrcamentoVendaPorChave(Long chave);
	List<OrcamentoVenda> listarOrcamentoVendas();
	List<OrcamentoVenda> pesquisarOrcamentoVendaPorNome(String nomeAtributo, String valor);
	OrcamentoVenda pesquisarOrcamentoVendaPorChave(Long chave);
}
