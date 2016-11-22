package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Fornecedor;

@Repository("fornecedor")
@Transactional
@SuppressWarnings("unchecked")
public class FornecedorDAOImpl extends AbstractDAO<Long, Fornecedor> implements FornecedorDAO{

	public Boolean salvarFornecedor(Fornecedor fornecedor) {
		return super.salvar(fornecedor);
	}

	public Boolean editarFornecedor(Fornecedor fornecedor) {
		return super.editar(fornecedor);
	}

	public Boolean excluirFornecedor(Fornecedor fornecedor) {
		return super.excluir(fornecedor);
	}

	public Boolean exluirFornecedorPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Fornecedor> listarFornecedors() {
		return (List<Fornecedor>) super.listarTodos();
	}

	public List<Fornecedor> pesquisarFornecedorPorNome(String nomeAtributo, String valor) {
		return (List<Fornecedor>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Fornecedor pesquisarFornecedorPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
