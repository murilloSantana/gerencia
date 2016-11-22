package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.CupomDesconto;

@Repository("cupomDescontoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class CupomDescontoDAOImpl extends AbstractDAO<Long, CupomDesconto> implements CupomDescontoDAO{

	public Boolean salvarCupomDesconto(CupomDesconto cupomDesconto) {
		return super.salvar(cupomDesconto);
	}

	public Boolean editarCupomDesconto(CupomDesconto cupomDesconto) {
		return super.editar(cupomDesconto);
	}

	public Boolean excluirCupomDesconto(CupomDesconto cupomDesconto) {
		return super.excluir(cupomDesconto);
	}

	public Boolean exluirCupomDescontoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<CupomDesconto> listarCupomDescontos() {
		return (List<CupomDesconto>) super.listarTodos();
	}

	public List<CupomDesconto> pesquisarCupomDescontoPorNome(String nomeAtributo, String valor) {
		return (List<CupomDesconto>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public CupomDesconto pesquisarCupomDescontoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
