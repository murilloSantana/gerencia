package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.FornecedorDAO;
import br.com.gerencia.model.Fornecedor;

@Service("fornecedorService")
public class FornecedorServiceImpl implements FornecedorService{
	
	@Autowired
	private FornecedorDAO fornecedorDAO;

	public Boolean salvarFornecedor(Fornecedor fornecedor) {
			return fornecedorDAO.salvarFornecedor(fornecedor);
		}

		public Boolean editarFornecedor(Fornecedor fornecedor) {
			return fornecedorDAO.editarFornecedor(fornecedor);
		}

		public Boolean excluirFornecedor(Fornecedor fornecedor) {
			return fornecedorDAO.excluirFornecedor(fornecedor);
		}

		public Boolean exluirFornecedorPorChave(Long chave) {
			return fornecedorDAO.exluirFornecedorPorChave(chave);
		}

		public List<Fornecedor> listarFornecedors() {
			return  fornecedorDAO.listarFornecedors();
		}

		public List<Fornecedor> pesquisarFornecedorPorNome(String nomeAtributo, String valor) {
			return  fornecedorDAO.pesquisarFornecedorPorNome(nomeAtributo, valor);
		}

		public Fornecedor pesquisarFornecedorPorChave(Long chave) {
			return fornecedorDAO.pesquisarFornecedorPorChave(chave);
		}
}
