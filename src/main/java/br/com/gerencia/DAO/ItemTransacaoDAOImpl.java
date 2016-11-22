package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.ItemTransacao;
@Repository("itemTransacaoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ItemTransacaoDAOImpl extends AbstractDAO<Long, ItemTransacao> implements ItemTransacaoDAO{

	public Boolean salvarItemTransacao(ItemTransacao itemTransacao) {
		return super.salvar(itemTransacao);
	}

	public Boolean editarItemTransacao(ItemTransacao itemTransacao) {
		return super.editar(itemTransacao);
	}

	public Boolean excluirItemTransacao(ItemTransacao itemTransacao) {
		return super.excluir(itemTransacao);
	}

	public Boolean exluirItemTransacaoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<ItemTransacao> listarItemTransacaos() {
		return (List<ItemTransacao>) super.listarTodos();
	}

	public List<ItemTransacao> pesquisarItemTransacaoPorNome(String nomeAtributo, String valor) {
		return (List<ItemTransacao>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public ItemTransacao pesquisarItemTransacaoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
