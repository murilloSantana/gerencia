package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.TelefoneDAO;
import br.com.gerencia.model.Telefone;

@Service("telefoneService")
public class TelefoneServiceImpl implements TelefoneService{

	@Autowired
	private TelefoneDAO telefoneDAO;

	public Boolean salvarTelefone(Telefone telefone) {
			return telefoneDAO.salvarTelefone(telefone);
		}

		public Boolean editarTelefone(Telefone telefone) {
			return telefoneDAO.editarTelefone(telefone);
		}

		public Boolean excluirTelefone(Telefone telefone) {
			return telefoneDAO.excluirTelefone(telefone);
		}

		public Boolean exluirTelefonePorChave(Long chave) {
			return telefoneDAO.exluirTelefonePorChave(chave);
		}

		public List<Telefone> listarTelefones() {
			return  telefoneDAO.listarTelefones();
		}

		public List<Telefone> pesquisarTelefonePorNome(String nomeAtributo, String valor) {
			return  telefoneDAO.pesquisarTelefonePorNome(nomeAtributo, valor);
		}

		public Telefone pesquisarTelefonePorChave(Long chave) {
			return telefoneDAO.pesquisarTelefonePorChave(chave);
		}
}
