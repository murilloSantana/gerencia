package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.ContaPessoaJuridica;
@Repository("pessoaJuridicaDAO")
@Transactional
@SuppressWarnings("unchecked")
public class PessoaJuridicaDAOImpl extends AbstractDAO<Long, ContaPessoaJuridica> implements PessoaJuridicaDAO{

	public Boolean salvarPessoaJuridica(ContaPessoaJuridica pessoaJuridica) {
		return super.salvar(pessoaJuridica);
	}

	public Boolean editarPessoaJuridica(ContaPessoaJuridica pessoaJuridica) {
		return super.editar(pessoaJuridica);
	}

	public Boolean excluirPessoaJuridica(ContaPessoaJuridica pessoaJuridica) {
		return super.excluir(pessoaJuridica);
	}

	public Boolean exluirPessoaJuridicaPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<ContaPessoaJuridica> listarPessoaJuridicas() {
		return (List<ContaPessoaJuridica>) super.listarTodos();
	}

	public List<ContaPessoaJuridica> pesquisarPessoaJuridicaPorNome(String nomeAtributo, String valor) {
		return (List<ContaPessoaJuridica>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public ContaPessoaJuridica pesquisarPessoaJuridicaPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
