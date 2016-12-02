package br.com.gerencia.service.loja;

import java.util.List;

import br.com.gerencia.model.loja.Maquina;
import br.com.gerencia.model.loja.ValorHora;

public interface ValorHoraService {
	Boolean salvarValorHora(ValorHora valorHora);
	Boolean editarValorHora(ValorHora valorHora);
	Boolean excluirValorHora(ValorHora valorHora);
	Boolean exluirValorHoraPorChave(Long chave);
	List<ValorHora> listarValorHora();
	List<ValorHora> pesquisarValorHoraPorNome(String nomeAtributo, String valor);
	ValorHora pesquisarValorHoraPorChave(Long chave);
}
