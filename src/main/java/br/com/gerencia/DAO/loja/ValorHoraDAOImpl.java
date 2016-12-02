package br.com.gerencia.DAO.loja;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.DAO.AbstractDAO;
import br.com.gerencia.model.loja.ValorHora;
@Repository("valorHoraDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ValorHoraDAOImpl extends AbstractDAO<Long, ValorHora> implements ValorHoraDAO{

	public Boolean salvarValorHora(ValorHora valorHora) {
		return super.salvar(valorHora);
	}

	public Boolean editarValorHora(ValorHora valorHora) {
		return super.editar(valorHora);
	}

	public Boolean excluirValorHora(ValorHora valorHora) {
		return super.excluir(valorHora);
	}

	public Boolean exluirValorHoraPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<ValorHora> listarValorHora() {
		return (List<ValorHora>) super.listarTodos();
	}

	public List<ValorHora> pesquisarValorHoraPorNome(String nomeAtributo, String valor) {
		return (List<ValorHora>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public ValorHora pesquisarValorHoraPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}

}
