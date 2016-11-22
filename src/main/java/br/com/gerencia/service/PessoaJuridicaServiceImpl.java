package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.PessoaJuridicaDAO;
import br.com.gerencia.model.ContaPessoaJuridica;

@Service("pessoaJuridicaService")
public class PessoaJuridicaServiceImpl implements PessoaJuridicaService{

	@Autowired
	private PessoaJuridicaDAO pessoaJuridicaDAO;

	public Boolean salvarPessoaJuridica(ContaPessoaJuridica pessoaJuridica) {
			return pessoaJuridicaDAO.salvarPessoaJuridica(pessoaJuridica);
		}

		public Boolean editarPessoaJuridica(ContaPessoaJuridica pessoaJuridica) {
			return pessoaJuridicaDAO.editarPessoaJuridica(pessoaJuridica);
		}

		public Boolean excluirPessoaJuridica(ContaPessoaJuridica pessoaJuridica) {
			return pessoaJuridicaDAO.excluirPessoaJuridica(pessoaJuridica);
		}

		public Boolean exluirPessoaJuridicaPorChave(Long chave) {
			return pessoaJuridicaDAO.exluirPessoaJuridicaPorChave(chave);
		}

		public List<ContaPessoaJuridica> listarPessoaJuridicas() {
			return  pessoaJuridicaDAO.listarPessoaJuridicas();
		}

		public List<ContaPessoaJuridica> pesquisarPessoaJuridicaPorNome(String nomeAtributo, String valor) {
			return  pessoaJuridicaDAO.pesquisarPessoaJuridicaPorNome(nomeAtributo, valor);
		}

		public ContaPessoaJuridica pesquisarPessoaJuridicaPorChave(Long chave) {
			return pessoaJuridicaDAO.pesquisarPessoaJuridicaPorChave(chave);
		}
}
