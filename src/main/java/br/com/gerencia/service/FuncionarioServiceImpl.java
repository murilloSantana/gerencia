package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.FuncionarioDAO;
import br.com.gerencia.model.Funcionario;

@Service("funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	public Boolean salvarFuncionario(Funcionario funcionario) {
			return funcionarioDAO.salvarFuncionario(funcionario);
		}

		public Boolean editarFuncionario(Funcionario funcionario) {
			return funcionarioDAO.editarFuncionario(funcionario);
		}

		public Boolean excluirFuncionario(Funcionario funcionario) {
			return funcionarioDAO.excluirFuncionario(funcionario);
		}

		public Boolean exluirFuncionarioPorChave(Long chave) {
			return funcionarioDAO.exluirFuncionarioPorChave(chave);
		}

		public List<Funcionario> listarFuncionarios() {
			return  funcionarioDAO.listarFuncionarios();
		}

		public List<Funcionario> pesquisarFuncionarioPorNome(String nomeAtributo, String valor) {
			return  funcionarioDAO.pesquisarFuncionarioPorNome(nomeAtributo, valor);
		}

		public Funcionario pesquisarFuncionarioPorChave(Long chave) {
			return funcionarioDAO.pesquisarFuncionarioPorChave(chave);
		}
}
