package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Unidade;
@Repository("unidadeDAO")
@Transactional
@SuppressWarnings("unchecked")
public class UnidadeDAOImpl extends AbstractDAO<Long, Unidade> implements UnidadeDAO{

	public Boolean salvarUnidade(Unidade unidade) {
		return super.salvar(unidade);
	}

	public Boolean editarUnidade(Unidade unidade) {
		return super.editar(unidade);
	}

	public Boolean excluirUnidade(Unidade unidade) {
		return super.excluir(unidade);
	}

	public Boolean exluirUnidadePorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Unidade> listarUnidades() {
		return (List<Unidade>) super.listarTodos();
	}

	public List<Unidade> pesquisarUnidadePorNome(String nomeAtributo,
			String valor) {
		return (List<Unidade>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Unidade pesquisarUnidadePorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}

	
}
