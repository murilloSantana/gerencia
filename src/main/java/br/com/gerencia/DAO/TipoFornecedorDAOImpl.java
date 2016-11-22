package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.TipoFornecedor;

@Repository("tipoFornecedorDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TipoFornecedorDAOImpl extends AbstractDAO<Long, TipoFornecedor> implements TipoFornecedorDAO{
	
	public Boolean salvarTipoFornecedor(TipoFornecedor tipoFornecedor) {
		return super.salvar(tipoFornecedor);
	}

	public Boolean editarTipoFornecedor(TipoFornecedor tipoFornecedor) {
		return super.editar(tipoFornecedor);
	}

	public Boolean excluirTipoFornecedor(TipoFornecedor tipoFornecedor) {
		return super.excluir(tipoFornecedor);
	}

	public Boolean exluirTipoFornecedorPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<TipoFornecedor> listarTipoFornecedors() {
		return (List<TipoFornecedor>) super.listarTodos();
	}

	public List<TipoFornecedor> pesquisarTipoFornecedorPorNome(String nomeAtributo, String valor) {
		return (List<TipoFornecedor>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public TipoFornecedor pesquisarTipoFornecedorPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
