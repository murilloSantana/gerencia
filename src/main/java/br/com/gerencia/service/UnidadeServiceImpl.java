package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.UnidadeDAO;
import br.com.gerencia.model.Unidade;

@Service("unidadeService")
public class UnidadeServiceImpl implements UnidadeService{
	
	@Autowired
	private UnidadeDAO unidadeDAO;

	public Boolean salvarUnidade(Unidade unidade) {
			return unidadeDAO.salvarUnidade(unidade);
		}

		public Boolean editarUnidade(Unidade unidade) {
			return unidadeDAO.editarUnidade(unidade);
		}

		public Boolean excluirUnidade(Unidade unidade) {
			return unidadeDAO.excluirUnidade(unidade);
		}

		public Boolean exluirUnidadePorChave(Long chave) {
			return unidadeDAO.exluirUnidadePorChave(chave);
		}

		public List<Unidade> listarUnidades() {
			return  unidadeDAO.listarUnidades();
		}

		public List<Unidade> pesquisarUnidadePorNome(String nomeAtributo, String valor) {
			return  unidadeDAO.pesquisarUnidadePorNome(nomeAtributo, valor);
		}

		public Unidade pesquisarUnidadePorChave(Long chave) {
			return unidadeDAO.pesquisarUnidadePorChave(chave);
		}
}
