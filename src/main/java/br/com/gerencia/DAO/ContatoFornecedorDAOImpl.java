package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.ContatoFornecedor;

@Repository("contatoFornecedorDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ContatoFornecedorDAOImpl extends AbstractDAO<Long, ContatoFornecedor> implements ContatoFornecedorDAO{

	public Boolean salvarContatoFornecedor(ContatoFornecedor contatoFornecedor) {
		return super.salvar(contatoFornecedor);
	}

	public Boolean editarContatoFornecedor(ContatoFornecedor contatoFornecedor) {
		return super.editar(contatoFornecedor);
	}

	public Boolean excluirContatoFornecedor(ContatoFornecedor contatoFornecedor) {
		return super.excluir(contatoFornecedor);
	}

	public Boolean exluirContatoFornecedorPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<ContatoFornecedor> listarContatoFornecedors() {
		return (List<ContatoFornecedor>) super.listarTodos();
	}

	public List<ContatoFornecedor> pesquisarContatoFornecedorPorNome(String nomeAtributo, String valor) {
		return (List<ContatoFornecedor>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public ContatoFornecedor pesquisarContatoFornecedorPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
