package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Unidade;

public interface UnidadeDAO {

	Boolean salvarUnidade(Unidade unidade);
	Boolean editarUnidade(Unidade unidade);
	Boolean excluirUnidade(Unidade unidade);
	Boolean exluirUnidadePorChave(Long chave);
	List<Unidade> listarUnidades();
	List<Unidade> pesquisarUnidadePorNome(String nomeAtributo, String valor);
	Unidade pesquisarUnidadePorChave(Long chave);
}
