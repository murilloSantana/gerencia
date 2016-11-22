package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gerencia.DAO.PessoaFisicaDAO;
import br.com.gerencia.model.ContaPessoaFisica;

public class PessoaFisicaServiceImpl implements PessoaFisicaService{

	@Autowired
	private PessoaFisicaDAO pessoaFisicaDAO;

	public Boolean salvarPessoaFisica(ContaPessoaFisica pessoaFisica) {
			return pessoaFisicaDAO.salvarPessoaFisica(pessoaFisica);
		}

		public Boolean editarPessoaFisica(ContaPessoaFisica pessoaFisica) {
			return pessoaFisicaDAO.editarPessoaFisica(pessoaFisica);
		}

		public Boolean excluirPessoaFisica(ContaPessoaFisica pessoaFisica) {
			return pessoaFisicaDAO.excluirPessoaFisica(pessoaFisica);
		}

		public Boolean exluirPessoaFisicaPorChave(Long chave) {
			return pessoaFisicaDAO.exluirPessoaFisicaPorChave(chave);
		}

		public List<ContaPessoaFisica> listarPessoaFisicas() {
			return  pessoaFisicaDAO.listarPessoaFisicas();
		}

		public List<ContaPessoaFisica> pesquisarPessoaFisicaPorNome(String nomeAtributo, String valor) {
			return  pessoaFisicaDAO.pesquisarPessoaFisicaPorNome(nomeAtributo, valor);
		}

		public ContaPessoaFisica pesquisarPessoaFisicaPorChave(Long chave) {
			return pessoaFisicaDAO.pesquisarPessoaFisicaPorChave(chave);
		}
}
