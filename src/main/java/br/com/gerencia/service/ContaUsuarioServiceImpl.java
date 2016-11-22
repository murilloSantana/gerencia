package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.ContaUsuarioDAO;
import br.com.gerencia.model.ContaUsuario;

@Service("contaService")
public class ContaUsuarioServiceImpl implements ContaUsuarioService{

	@Autowired
	private ContaUsuarioDAO contaDAO;

	public Boolean salvarConta(ContaUsuario conta) {
			return contaDAO.salvarConta(conta);
		}

		public Boolean editarConta(ContaUsuario conta) {
			return contaDAO.editarConta(conta);
		}

		public Boolean excluirConta(ContaUsuario conta) {
			return contaDAO.excluirConta(conta);
		}

		public Boolean exluirContaPorChave(Long chave) {
			return contaDAO.exluirContaPorChave(chave);
		}

		public List<ContaUsuario> listarContas() {
			return  contaDAO.listarContas();
		}

		public List<ContaUsuario> pesquisarContaPorNome(String nomeAtributo, String valor) {
			return  contaDAO.pesquisarContaPorNome(nomeAtributo, valor);
		}

		public ContaUsuario pesquisarContaPorChave(Long chave) {
			return contaDAO.pesquisarContaPorChave(chave);
		}
		
		public ContaUsuario pesquisarConta(String username){
			return contaDAO.pesquisarConta(username);
		}
}
