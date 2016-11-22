package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.ContaUsuario;
@Repository("contaDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ContaUsuarioDAOImpl extends DefaultAbstractDAO<Long, ContaUsuario> implements ContaUsuarioDAO{

	public Boolean salvarConta(ContaUsuario conta) {
		return super.salvarDefault(conta);
	}

	public Boolean editarConta(ContaUsuario conta) {
		return super.editarDefault(conta);
	}

	public Boolean excluirConta(ContaUsuario conta) {
		return super.excluirDefault(conta);
	}

	public Boolean exluirContaPorChave(Long chave) {
		return super.excluirPorChaveDefault(chave);
	}

	public List<ContaUsuario> listarContas() {
		return (List<ContaUsuario>) super.listarTodosDefault();
	}

	public List<ContaUsuario> pesquisarContaPorNome(String nomeAtributo, String valor) {
		return (List<ContaUsuario>) super.pesquisarPorNomeDefault(nomeAtributo, valor);
	}

	public ContaUsuario pesquisarContaPorChave(Long chave) {
		return super.pesquisarPorChaveDefault(chave);
	}

	public ContaUsuario pesquisarConta(String username){
		return (ContaUsuario) super.pesquisarContaDefault(username);
	}
}
