package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Permissao;

@Repository("permissaoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class PermissaoDAOImpl  extends AbstractDAO<Long, Permissao> implements PermissaoDAO{

	public Boolean salvarPermissao(Permissao permissao) {
		return super.salvar(permissao);
	}

	public Boolean editarPermissao(Permissao permissao) {
		return super.editar(permissao);
	}

	public Boolean excluirPermissao(Permissao permissao) {
		return super.excluir(permissao);
	}

	public Boolean exluirPermissaoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Permissao> listarPermissaos() {
		return (List<Permissao>) super.listarTodos();
	}

	public List<Permissao> pesquisarPermissaoPorNome(String nomeAtributo, String valor) {
		return (List<Permissao>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Permissao pesquisarPermissaoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
