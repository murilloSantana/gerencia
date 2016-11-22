package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Funcionario;

@Repository("funcionarioDAO")
@Transactional
@SuppressWarnings("unchecked")
public class FuncionarioDAOImpl extends AbstractDAO<Long, Funcionario> implements FuncionarioDAO{

	public Boolean salvarFuncionario(Funcionario funcionario) {
		return super.salvar(funcionario);
	}

	public Boolean editarFuncionario(Funcionario funcionario) {
		return super.editar(funcionario);
	}

	public Boolean excluirFuncionario(Funcionario funcionario) {
		return super.excluir(funcionario);
	}

	public Boolean exluirFuncionarioPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Funcionario> listarFuncionarios() {
		return (List<Funcionario>) super.listarTodos();
	}

	public List<Funcionario> pesquisarFuncionarioPorNome(String nomeAtributo, String valor) {
		return (List<Funcionario>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Funcionario pesquisarFuncionarioPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
