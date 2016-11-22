package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Perfil;

@Repository("perfil")
@Transactional
@SuppressWarnings("unchecked")
public class PerfilDAOImpl extends AbstractDAO<Long, Perfil> implements PerfilDAO {
	
	public Boolean salvarPerfil(Perfil perfil) {
		return super.salvar(perfil);
	}

	public Boolean editarPerfil(Perfil perfil) {
		return super.editar(perfil);
	}

	public Boolean excluirPerfil(Perfil perfil) {
		return super.excluir(perfil);
	}

	public Boolean exluirPerfilPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Perfil> listarPerfils() {
		return (List<Perfil>) super.listarTodos();
	}

	public List<Perfil> pesquisarPerfilPorNome(String nomeAtributo, String valor) {
		return (List<Perfil>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Perfil pesquisarPerfilPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
