package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.InformacoesTecnicas;

@Repository("informacoesTecnicasDAO")
@Transactional
@SuppressWarnings("unchecked")
public class InformacoesTecnicasDAOImpl extends AbstractDAO<Long, InformacoesTecnicas> implements InformacoesTecnicasDAO{

	public Boolean salvarInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas) {
		return super.salvar(informacoesTecnicas);
	}

	public Boolean editarInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas) {
		return super.editar(informacoesTecnicas);
	}

	public Boolean excluirInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas) {
		return super.excluir(informacoesTecnicas);
	}

	public Boolean exluirInformacoesTecnicasPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<InformacoesTecnicas> listarInformacoesTecnicass() {
		return (List<InformacoesTecnicas>) super.listarTodos();
	}

	public List<InformacoesTecnicas> pesquisarInformacoesTecnicasPorNome(String nomeAtributo, String valor) {
		return (List<InformacoesTecnicas>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public InformacoesTecnicas pesquisarInformacoesTecnicasPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
