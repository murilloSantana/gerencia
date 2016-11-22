package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.TempoGuardado;
@Repository("tempoGuardadoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TempoGuardadoDAOImpl extends AbstractDAO<Long, TempoGuardado> implements TempoGuardadoDAO{

	public Boolean salvarTempoGuardado(TempoGuardado tempoGuardado) {
		return super.salvar(tempoGuardado);
	}

	public Boolean editarTempoGuardado(TempoGuardado tempoGuardado) {
		return super.editar(tempoGuardado);
	}

	public Boolean excluirTempoGuardado(TempoGuardado tempoGuardado) {
		return super.excluir(tempoGuardado);
	}

	public Boolean exluirTempoGuardadoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<TempoGuardado> listarTempoGuardados() {
		return (List<TempoGuardado>) super.listarTodos();
	}

	public List<TempoGuardado> pesquisarTempoGuardadoPorNome(String nomeAtributo, String valor) {
		return (List<TempoGuardado>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public TempoGuardado pesquisarTempoGuardadoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
