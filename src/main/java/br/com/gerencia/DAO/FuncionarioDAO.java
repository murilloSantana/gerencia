package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Funcionario;

public interface FuncionarioDAO {

	Boolean salvarFuncionario(Funcionario funcionario);
	Boolean editarFuncionario(Funcionario funcionario);
	Boolean excluirFuncionario(Funcionario funcionario);
	Boolean exluirFuncionarioPorChave(Long chave);
	List<Funcionario> listarFuncionarios();
	List<Funcionario> pesquisarFuncionarioPorNome(String nomeAtributo, String valor);
	Funcionario pesquisarFuncionarioPorChave(Long chave);
}
