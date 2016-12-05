package br.com.gerencia.DAO.loja;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.DAO.AbstractDAO;
import br.com.gerencia.model.loja.Maquina;
@Repository("maquinaDAO")
@SuppressWarnings(value="unchecked")
@Transactional
public class MaquinaDAOImpl extends AbstractDAO<Long, Maquina> implements MaquinaDAO{

	public Boolean salvarMaquina(Maquina maquina) {
		return super.salvar(maquina);
	}

	public Boolean editarMaquina(Maquina maquina) {
		return super.editar(maquina);
	}

	public Boolean excluirMaquina(Maquina maquina) {
		return super.excluir(maquina);
	}

	public Boolean exluirMaquinaPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Maquina> listarMaquinas() {
		return (List<Maquina>) super.listarTodos();
	}

	public List<Maquina> pesquisarMaquinaPorNome(String nomeAtributo, String valor) {
		return (List<Maquina>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Maquina pesquisarMaquinaPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}


	public List<Maquina> pesquisarMaquinaPorNome(String nomeAtributo, Integer valor) {
		return (List<Maquina>) super.pesquisarPorNome(nomeAtributo, valor);
	}

}
