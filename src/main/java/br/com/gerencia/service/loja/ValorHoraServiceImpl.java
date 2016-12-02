package br.com.gerencia.service.loja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.loja.ValorHoraDAO;
import br.com.gerencia.model.loja.ValorHora;

@Service("valorHoraService")
public class ValorHoraServiceImpl implements ValorHoraService{
	@Autowired
	private ValorHoraDAO valorHoraDAO;
	
	public Boolean salvarValorHora(ValorHora valorHora) {
		return valorHoraDAO.salvarValorHora(valorHora);
	}

	public Boolean editarValorHora(ValorHora valorHora) {
		return valorHoraDAO.editarValorHora(valorHora);
	}

	public Boolean excluirValorHora(ValorHora valorHora) {
		return valorHoraDAO.excluirValorHora(valorHora);
	}

	public Boolean exluirValorHoraPorChave(Long chave) {
		return valorHoraDAO.exluirValorHoraPorChave(chave);
	}

	public List<ValorHora> listarValorHora() {
		return valorHoraDAO.listarValorHora();
	}

	public List<ValorHora> pesquisarValorHoraPorNome(String nomeAtributo, String valor) {
		return valorHoraDAO.pesquisarValorHoraPorNome(nomeAtributo, valor);
	}

	public ValorHora pesquisarValorHoraPorChave(Long chave) {
		return valorHoraDAO.pesquisarValorHoraPorChave(chave);
	}

}
