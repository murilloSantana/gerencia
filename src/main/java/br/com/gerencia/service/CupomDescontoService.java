package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.CupomDesconto;

public interface CupomDescontoService {

	Boolean salvarCupomDesconto(CupomDesconto cupomDesconto);
	Boolean editarCupomDesconto(CupomDesconto cupomDesconto);
	Boolean excluirCupomDesconto(CupomDesconto cupomDesconto);
	Boolean exluirCupomDescontoPorChave(Long chave);
	List<CupomDesconto> listarCupomDescontos();
	List<CupomDesconto> pesquisarCupomDescontoPorNome(String nomeAtributo, String valor);
	CupomDesconto pesquisarCupomDescontoPorChave(Long chave);
}
