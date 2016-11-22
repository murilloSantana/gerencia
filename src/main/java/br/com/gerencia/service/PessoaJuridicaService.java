package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.ContaPessoaJuridica;

public interface PessoaJuridicaService {

	Boolean salvarPessoaJuridica(ContaPessoaJuridica classe);
	Boolean editarPessoaJuridica(ContaPessoaJuridica classe);
	Boolean excluirPessoaJuridica(ContaPessoaJuridica classe);
	Boolean exluirPessoaJuridicaPorChave(Long chave);
	List<ContaPessoaJuridica> listarPessoaJuridicas();
	List<ContaPessoaJuridica> pesquisarPessoaJuridicaPorNome(String nomeAtributo, String valor);
	ContaPessoaJuridica pesquisarPessoaJuridicaPorChave(Long chave);
}
