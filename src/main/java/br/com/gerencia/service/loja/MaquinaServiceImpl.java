package br.com.gerencia.service.loja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.loja.MaquinaDAO;
import br.com.gerencia.model.loja.Maquina;

@Service("maquinaService")
public class MaquinaServiceImpl implements MaquinaService{
	@Autowired
	private MaquinaDAO maquinaDAO;
	
	public Boolean salvarMaquina(Maquina maquina) {
		return maquinaDAO.salvarMaquina(maquina);
	}

	public Boolean editarMaquina(Maquina maquina) {
		return maquinaDAO.editarMaquina(maquina);
	}

	public Boolean excluirMaquina(Maquina maquina) {
		return maquinaDAO.excluirMaquina(maquina);
	}

	public Boolean exluirMaquinaPorChave(Long chave) {
		return maquinaDAO.exluirMaquinaPorChave(chave);
	}

	public List<Maquina> listarMaquinas() {
		return maquinaDAO.listarMaquinas();
	}

	public List<Maquina> pesquisarMaquinaPorNome(String nomeAtributo, String valor) {
		return maquinaDAO.pesquisarMaquinaPorNome(nomeAtributo, valor);
	}

	public Maquina pesquisarMaquinaPorChave(Long chave) {
		return maquinaDAO.pesquisarMaquinaPorChave(chave);
	}

	public List<Maquina> pesquisarMaquinaPorNome(String nomeAtributo, Integer valor) {
		return maquinaDAO.pesquisarMaquinaPorNome(nomeAtributo, valor);
	}

}
