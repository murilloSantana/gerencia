package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.PerfilDAO;
import br.com.gerencia.model.Perfil;

@Service("perfilService")
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	private PerfilDAO perfilDAO;

	public Boolean salvarPerfil(Perfil perfil) {
			return perfilDAO.salvarPerfil(perfil);
		}

		public Boolean editarPerfil(Perfil perfil) {
			return perfilDAO.editarPerfil(perfil);
		}

		public Boolean excluirPerfil(Perfil perfil) {
			return perfilDAO.excluirPerfil(perfil);
		}

		public Boolean exluirPerfilPorChave(Long chave) {
			return perfilDAO.exluirPerfilPorChave(chave);
		}

		public List<Perfil> listarPerfils() {
			return  perfilDAO.listarPerfils();
		}

		public List<Perfil> pesquisarPerfilPorNome(String nomeAtributo, String valor) {
			return  perfilDAO.pesquisarPerfilPorNome(nomeAtributo, valor);
		}

		public Perfil pesquisarPerfilPorChave(Long chave) {
			return perfilDAO.pesquisarPerfilPorChave(chave);
		}
}
