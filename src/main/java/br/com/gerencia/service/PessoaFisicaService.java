package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.ContaPessoaFisica;

public interface PessoaFisicaService {

	Boolean salvarPessoaFisica(ContaPessoaFisica pessoaFisica);
	Boolean editarPessoaFisica(ContaPessoaFisica pessoaFisica);
	Boolean excluirPessoaFisica(ContaPessoaFisica pessoaFisica);
	Boolean exluirPessoaFisicaPorChave(Long chave);
	List<ContaPessoaFisica> listarPessoaFisicas();
	List<ContaPessoaFisica> pesquisarPessoaFisicaPorNome(String nomeAtributo, String valor);
	ContaPessoaFisica pesquisarPessoaFisicaPorChave(Long chave);
}
