package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.TipoFornecedorDAO;
import br.com.gerencia.model.TipoFornecedor;

@Service("tipoFornecedorService")
public class TipoFornecedorServiceImpl implements TipoFornecedorService{

	@Autowired
	private TipoFornecedorDAO tipoFornecedorDAO;

	public Boolean salvarTipoFornecedor(TipoFornecedor tipoFornecedor) {
			return tipoFornecedorDAO.salvarTipoFornecedor(tipoFornecedor);
		}

		public Boolean editarTipoFornecedor(TipoFornecedor tipoFornecedor) {
			return tipoFornecedorDAO.editarTipoFornecedor(tipoFornecedor);
		}

		public Boolean excluirTipoFornecedor(TipoFornecedor tipoFornecedor) {
			return tipoFornecedorDAO.excluirTipoFornecedor(tipoFornecedor);
		}

		public Boolean exluirTipoFornecedorPorChave(Long chave) {
			return tipoFornecedorDAO.exluirTipoFornecedorPorChave(chave);
		}

		public List<TipoFornecedor> listarTipoFornecedors() {
			return  tipoFornecedorDAO.listarTipoFornecedors();
		}

		public List<TipoFornecedor> pesquisarTipoFornecedorPorNome(String nomeAtributo, String valor) {
			return  tipoFornecedorDAO.pesquisarTipoFornecedorPorNome(nomeAtributo, valor);
		}

		public TipoFornecedor pesquisarTipoFornecedorPorChave(Long chave) {
			return tipoFornecedorDAO.pesquisarTipoFornecedorPorChave(chave);
		}
}
