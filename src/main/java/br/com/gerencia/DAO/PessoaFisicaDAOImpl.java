package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.ContaPessoaFisica;

@Repository("pessoaFisicaDAO")
@Transactional
@SuppressWarnings("unchecked")
public class PessoaFisicaDAOImpl extends AbstractDAO<Long, ContaPessoaFisica> implements PessoaFisicaDAO{

	public Boolean salvarPessoaFisica(ContaPessoaFisica pessoaFisica) {
		return super.salvar(pessoaFisica);
	}

	public Boolean editarPessoaFisica(ContaPessoaFisica pessoaFisica) {
		return super.editar(pessoaFisica);
	}

	public Boolean excluirPessoaFisica(ContaPessoaFisica pessoaFisica) {
		return super.excluir(pessoaFisica);
	}

	public Boolean exluirPessoaFisicaPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<ContaPessoaFisica> listarPessoaFisicas() {
		return (List<ContaPessoaFisica>) super.listarTodos();
	}

	public List<ContaPessoaFisica> pesquisarPessoaFisicaPorNome(String nomeAtributo, String valor) {
		return (List<ContaPessoaFisica>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public ContaPessoaFisica pesquisarPessoaFisicaPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
