package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.ContatoFornecedorDAO;
import br.com.gerencia.model.ContatoFornecedor;

@Service("contatoService")
public class ContatoFornecedorServiceImpl implements ContatoFornecedorService{

	@Autowired
	private ContatoFornecedorDAO contatoFornecedorDAO;

	public Boolean salvarContatoFornecedor(ContatoFornecedor contatoFornecedor) {
			return contatoFornecedorDAO.salvarContatoFornecedor(contatoFornecedor);
		}

		public Boolean editarContatoFornecedor(ContatoFornecedor contatoFornecedor) {
			return contatoFornecedorDAO.editarContatoFornecedor(contatoFornecedor);
		}

		public Boolean excluirContatoFornecedor(ContatoFornecedor contatoFornecedor) {
			return contatoFornecedorDAO.excluirContatoFornecedor(contatoFornecedor);
		}

		public Boolean exluirContatoFornecedorPorChave(Long chave) {
			return contatoFornecedorDAO.exluirContatoFornecedorPorChave(chave);
		}

		public List<ContatoFornecedor> listarContatoFornecedors() {
			return  contatoFornecedorDAO.listarContatoFornecedors();
		}

		public List<ContatoFornecedor> pesquisarContatoFornecedorPorNome(String nomeAtributo, String valor) {
			return  contatoFornecedorDAO.pesquisarContatoFornecedorPorNome(nomeAtributo, valor);
		}

		public ContatoFornecedor pesquisarContatoFornecedorPorChave(Long chave) {
			return contatoFornecedorDAO.pesquisarContatoFornecedorPorChave(chave);
		}
}
