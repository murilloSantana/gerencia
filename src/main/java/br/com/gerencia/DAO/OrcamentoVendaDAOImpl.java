package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.OrcamentoVenda;
@Repository("orcamentoVendaDAO")
@Transactional
@SuppressWarnings("unchecked")
public class OrcamentoVendaDAOImpl extends AbstractDAO<Long, OrcamentoVenda> implements OrcamentoVendaDAO{

	public Boolean salvarOrcamentoVenda(OrcamentoVenda orcamentoVenda) {
		return super.salvar(orcamentoVenda);
	}

	public Boolean editarOrcamentoVenda(OrcamentoVenda orcamentoVenda) {
		return super.editar(orcamentoVenda);
	}

	public Boolean excluirOrcamentoVenda(OrcamentoVenda orcamentoVenda) {
		return super.excluir(orcamentoVenda);
	}

	public Boolean exluirOrcamentoVendaPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<OrcamentoVenda> listarOrcamentoVendas() {
		return (List<OrcamentoVenda>) super.listarTodos();
	}

	public List<OrcamentoVenda> pesquisarOrcamentoVendaPorNome(String nomeAtributo, String valor) {
		return (List<OrcamentoVenda>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public OrcamentoVenda pesquisarOrcamentoVendaPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
