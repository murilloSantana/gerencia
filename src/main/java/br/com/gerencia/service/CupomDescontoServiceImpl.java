package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.CupomDescontoDAO;
import br.com.gerencia.model.CupomDesconto;

@Service("cupomService")
public class CupomDescontoServiceImpl implements CupomDescontoService{
	
	@Autowired
	private CupomDescontoDAO cupomDescontoDAO;

	public Boolean salvarCupomDesconto(CupomDesconto cupomDesconto) {
			return cupomDescontoDAO.salvarCupomDesconto(cupomDesconto);
		}

		public Boolean editarCupomDesconto(CupomDesconto cupomDesconto) {
			return cupomDescontoDAO.editarCupomDesconto(cupomDesconto);
		}

		public Boolean excluirCupomDesconto(CupomDesconto cupomDesconto) {
			return cupomDescontoDAO.excluirCupomDesconto(cupomDesconto);
		}

		public Boolean exluirCupomDescontoPorChave(Long chave) {
			return cupomDescontoDAO.exluirCupomDescontoPorChave(chave);
		}

		public List<CupomDesconto> listarCupomDescontos() {
			return  cupomDescontoDAO.listarCupomDescontos();
		}

		public List<CupomDesconto> pesquisarCupomDescontoPorNome(String nomeAtributo, String valor) {
			return  cupomDescontoDAO.pesquisarCupomDescontoPorNome(nomeAtributo, valor);
		}

		public CupomDesconto pesquisarCupomDescontoPorChave(Long chave) {
			return cupomDescontoDAO.pesquisarCupomDescontoPorChave(chave);
		}
}
