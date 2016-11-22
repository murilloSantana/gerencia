package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.CondicaoPagamentoDAO;
import br.com.gerencia.model.CondicaoPagamento;

@Service("condicaoPagamentoService")
public class CondicaoPagamentoServiceImpl implements CondicaoPagamentoService{

	@Autowired
	private CondicaoPagamentoDAO condicaoPagamentoDAO;

	public Boolean salvarCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
			return condicaoPagamentoDAO.salvarCondicaoPagamento(condicaoPagamento);
		}

		public Boolean editarCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
			return condicaoPagamentoDAO.editarCondicaoPagamento(condicaoPagamento);
		}

		public Boolean excluirCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
			return condicaoPagamentoDAO.excluirCondicaoPagamento(condicaoPagamento);
		}

		public Boolean exluirCondicaoPagamentoPorChave(Long chave) {
			return condicaoPagamentoDAO.exluirCondicaoPagamentoPorChave(chave);
		}

		public List<CondicaoPagamento> listarCondicaoPagamentos() {
			return  condicaoPagamentoDAO.listarCondicaoPagamentos();
		}

		public List<CondicaoPagamento> pesquisarCondicaoPagamentoPorNome(String nomeAtributo, String valor) {
			return  condicaoPagamentoDAO.pesquisarCondicaoPagamentoPorNome(nomeAtributo, valor);
		}

		public CondicaoPagamento pesquisarCondicaoPagamentoPorChave(Long chave) {
			return condicaoPagamentoDAO.pesquisarCondicaoPagamentoPorChave(chave);
		}
}
