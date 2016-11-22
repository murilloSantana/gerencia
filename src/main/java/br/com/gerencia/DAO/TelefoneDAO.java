package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Telefone;

public interface TelefoneDAO {

	Boolean salvarTelefone(Telefone telefone);
	Boolean editarTelefone(Telefone telefone);
	Boolean excluirTelefone(Telefone telefone);
	Boolean exluirTelefonePorChave(Long chave);
	List<Telefone> listarTelefones();
	List<Telefone> pesquisarTelefonePorNome(String nomeAtributo, String valor);
	Telefone pesquisarTelefonePorChave(Long chave);
}
