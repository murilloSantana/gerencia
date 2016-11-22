package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.ContaPessoaJuridica;

public interface PessoaJuridicaDAO {

	Boolean salvarPessoaJuridica(ContaPessoaJuridica pessoaJuridica);
	Boolean editarPessoaJuridica(ContaPessoaJuridica pessoaJuridica);
	Boolean excluirPessoaJuridica(ContaPessoaJuridica pessoaJuridica);
	Boolean exluirPessoaJuridicaPorChave(Long chave);
	List<ContaPessoaJuridica> listarPessoaJuridicas();
	List<ContaPessoaJuridica> pesquisarPessoaJuridicaPorNome(String nomeAtributo, String valor);
	ContaPessoaJuridica pesquisarPessoaJuridicaPorChave(Long chave);
}
