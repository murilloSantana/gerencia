package br.com.gerencia.service.loja;

import java.util.List;

import br.com.gerencia.model.loja.Maquina;

public interface MaquinaService {

	Boolean salvarMaquina(Maquina maquina);
	Boolean editarMaquina(Maquina maquina);
	Boolean excluirMaquina(Maquina maquina);
	Boolean exluirMaquinaPorChave(Long chave);
	List<Maquina> listarMaquinas();
	List<Maquina> pesquisarMaquinaPorNome(String nomeAtributo, String valor);
	List<Maquina> pesquisarMaquinaPorNome(String nomeAtributo, Integer valor);
	Maquina pesquisarMaquinaPorChave(Long chave);

}
