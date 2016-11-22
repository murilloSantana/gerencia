package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.PermissaoDAO;
import br.com.gerencia.model.Permissao;

@Service("permissaoService")
public class PermissaoServiceImpl implements PermissaoService{

	@Autowired
	private PermissaoDAO permissaoDAO;

	public Boolean salvarPermissao(Permissao permissao) {
			return permissaoDAO.salvarPermissao(permissao);
		}

		public Boolean editarPermissao(Permissao permissao) {
			return permissaoDAO.editarPermissao(permissao);
		}

		public Boolean excluirPermissao(Permissao permissao) {
			return permissaoDAO.excluirPermissao(permissao);
		}

		public Boolean exluirPermissaoPorChave(Long chave) {
			return permissaoDAO.exluirPermissaoPorChave(chave);
		}

		public List<Permissao> listarPermissaos() {
			return  permissaoDAO.listarPermissaos();
		}

		public List<Permissao> pesquisarPermissaoPorNome(String nomeAtributo, String valor) {
			return  permissaoDAO.pesquisarPermissaoPorNome(nomeAtributo, valor);
		}

		public Permissao pesquisarPermissaoPorChave(Long chave) {
			return permissaoDAO.pesquisarPermissaoPorChave(chave);
		}
}
