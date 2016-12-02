package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.InformacoesTecnicasDAO;
import br.com.gerencia.model.InformacoesTecnicas;

@Service("informacoesTecnicasService")
public class InformacoesTecnicasServiceImpl implements InformacoesTecnicasService {

	@Autowired
	private InformacoesTecnicasDAO informacoesTecnicasDAO;

	public InformacoesTecnicas salvarInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas) {
		InformacoesTecnicas info = informacoesTecnicasDAO.salvarInformacoesTecnicas(informacoesTecnicas);
		return info;
	}

	public Boolean editarInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas) {
		return informacoesTecnicasDAO.editarInformacoesTecnicas(informacoesTecnicas);
	}

	public Boolean excluirInformacoesTecnicas(InformacoesTecnicas informacoesTecnicas) {
		return informacoesTecnicasDAO.excluirInformacoesTecnicas(informacoesTecnicas);
	}

	public Boolean exluirInformacoesTecnicasPorChave(Long chave) {
		return informacoesTecnicasDAO.exluirInformacoesTecnicasPorChave(chave);
	}

	public List<InformacoesTecnicas> listarInformacoesTecnicass() {
		return informacoesTecnicasDAO.listarInformacoesTecnicass();
	}

	public List<InformacoesTecnicas> pesquisarInformacoesTecnicasPorNome(String nomeAtributo, String valor) {
		return informacoesTecnicasDAO.pesquisarInformacoesTecnicasPorNome(nomeAtributo, valor);
	}

	public InformacoesTecnicas pesquisarInformacoesTecnicasPorChave(Long chave) {
		return informacoesTecnicasDAO.pesquisarInformacoesTecnicasPorChave(chave);
	}
}
