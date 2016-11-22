package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.OrcamentoVendaDAO;
import br.com.gerencia.model.OrcamentoVenda;

@Service("orcamentoVendaService")
public class OrcamentoVendaServiceImpl implements OrcamentoVendaService{

	@Autowired
	private OrcamentoVendaDAO orcamentoVendaDAO;

	public Boolean salvarOrcamentoVenda(OrcamentoVenda orcamentoVenda) {
			return orcamentoVendaDAO.salvarOrcamentoVenda(orcamentoVenda);
		}

		public Boolean editarOrcamentoVenda(OrcamentoVenda orcamentoVenda) {
			return orcamentoVendaDAO.editarOrcamentoVenda(orcamentoVenda);
		}

		public Boolean excluirOrcamentoVenda(OrcamentoVenda orcamentoVenda) {
			return orcamentoVendaDAO.excluirOrcamentoVenda(orcamentoVenda);
		}

		public Boolean exluirOrcamentoVendaPorChave(Long chave) {
			return orcamentoVendaDAO.exluirOrcamentoVendaPorChave(chave);
		}

		public List<OrcamentoVenda> listarOrcamentoVendas() {
			return  orcamentoVendaDAO.listarOrcamentoVendas();
		}

		public List<OrcamentoVenda> pesquisarOrcamentoVendaPorNome(String nomeAtributo, String valor) {
			return  orcamentoVendaDAO.pesquisarOrcamentoVendaPorNome(nomeAtributo, valor);
		}

		public OrcamentoVenda pesquisarOrcamentoVendaPorChave(Long chave) {
			return orcamentoVendaDAO.pesquisarOrcamentoVendaPorChave(chave);
		}
}
