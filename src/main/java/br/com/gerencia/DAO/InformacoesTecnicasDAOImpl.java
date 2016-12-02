package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.gerencia.model.InformacoesTecnicas;

@Repository("informacoesTecnicasDAO")
@Transactional
@SuppressWarnings("unchecked")
public class InformacoesTecnicasDAOImpl extends AbstractDAO<Long, InformacoesTecnicas> implements InformacoesTecnicasDAO{
	
	@Autowired
	private SessionFactory sf;
	protected Session getSession(){
		return sf.getCurrentSession();
	}

	public InformacoesTecnicas salvarInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas) {
		super.getSession().merge(informacoesTecnicas);
		return informacoesTecnicas;
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
