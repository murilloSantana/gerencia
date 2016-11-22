package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Telefone;
@Repository("telefoneDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TelefoneDAOImpl extends AbstractDAO<Long, Telefone> implements TelefoneDAO{

	public Boolean salvarTelefone(Telefone telefone) {
		return super.salvar(telefone);
	}

	public Boolean editarTelefone(Telefone telefone) {
		return super.editar(telefone);
	}

	public Boolean excluirTelefone(Telefone telefone) {
		return super.excluir(telefone);
	}

	public Boolean exluirTelefonePorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Telefone> listarTelefones() {
		return (List<Telefone>) super.listarTodos();
	}

	public List<Telefone> pesquisarTelefonePorNome(String nomeAtributo, String valor) {
		return (List<Telefone>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Telefone pesquisarTelefonePorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
