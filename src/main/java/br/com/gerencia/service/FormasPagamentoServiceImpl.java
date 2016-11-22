package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.FormasPagamentoDAO;
import br.com.gerencia.model.FormasPagamento;

@Service("formasPagamentoService")
public class FormasPagamentoServiceImpl implements FormasPagamentoService{

	@Autowired
	private FormasPagamentoDAO formasPagamentoDAO;

	public Boolean salvarFormasPagamento(FormasPagamento formasPagamento) {
			return formasPagamentoDAO.salvarFormasPagamento(formasPagamento);
		}

		public Boolean editarFormasPagamento(FormasPagamento formasPagamento) {
			return formasPagamentoDAO.editarFormasPagamento(formasPagamento);
		}

		public Boolean excluirFormasPagamento(FormasPagamento formasPagamento) {
			return formasPagamentoDAO.excluirFormasPagamento(formasPagamento);
		}

		public Boolean exluirFormasPagamentoPorChave(Long chave) {
			return formasPagamentoDAO.exluirFormasPagamentoPorChave(chave);
		}

		public List<FormasPagamento> listarFormasPagamentos() {
			return  formasPagamentoDAO.listarFormasPagamentos();
		}

		public List<FormasPagamento> pesquisarFormasPagamentoPorNome(String nomeAtributo, String valor) {
			return  formasPagamentoDAO.pesquisarFormasPagamentoPorNome(nomeAtributo, valor);
		}

		public FormasPagamento pesquisarFormasPagamentoPorChave(Long chave) {
			return formasPagamentoDAO.pesquisarFormasPagamentoPorChave(chave);
		}
}
