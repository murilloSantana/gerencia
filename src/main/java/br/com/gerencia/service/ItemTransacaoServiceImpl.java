package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.ItemTransacaoDAO;
import br.com.gerencia.model.ItemTransacao;

@Service("itemTransacaoService")
public class ItemTransacaoServiceImpl implements ItemTransacaoService{

	@Autowired
	private ItemTransacaoDAO itemTransacaoDAO;

	public Boolean salvarItemTransacao(ItemTransacao itemTransacao) {
			return itemTransacaoDAO.salvarItemTransacao(itemTransacao);
		}

		public Boolean editarItemTransacao(ItemTransacao itemTransacao) {
			return itemTransacaoDAO.editarItemTransacao(itemTransacao);
		}

		public Boolean excluirItemTransacao(ItemTransacao itemTransacao) {
			return itemTransacaoDAO.excluirItemTransacao(itemTransacao);
		}

		public Boolean exluirItemTransacaoPorChave(Long chave) {
			return itemTransacaoDAO.exluirItemTransacaoPorChave(chave);
		}

		public List<ItemTransacao> listarItemTransacaos() {
			return  itemTransacaoDAO.listarItemTransacaos();
		}

		public List<ItemTransacao> pesquisarItemTransacaoPorNome(String nomeAtributo, String valor) {
			return  itemTransacaoDAO.pesquisarItemTransacaoPorNome(nomeAtributo, valor);
		}

		public ItemTransacao pesquisarItemTransacaoPorChave(Long chave) {
			return itemTransacaoDAO.pesquisarItemTransacaoPorChave(chave);
		}
}
