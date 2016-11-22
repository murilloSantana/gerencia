package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.CupomDesconto;

public interface CupomDescontoDAO {

	Boolean salvarCupomDesconto(CupomDesconto cupomDesconto);
	Boolean editarCupomDesconto(CupomDesconto cupomDesconto);
	Boolean excluirCupomDesconto(CupomDesconto cupomDesconto);
	Boolean exluirCupomDescontoPorChave(Long chave);
	List<CupomDesconto> listarCupomDescontos();
	List<CupomDesconto> pesquisarCupomDescontoPorNome(String nomeAtributo, String valor);
	CupomDesconto pesquisarCupomDescontoPorChave(Long chave);
}
