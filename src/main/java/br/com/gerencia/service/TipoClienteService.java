package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.TipoCliente;

public interface TipoClienteService {

	Boolean salvarTipoCliente(TipoCliente tipoCliente);
	Boolean editarTipoCliente(TipoCliente tipoCliente);
	Boolean excluirTipoCliente(TipoCliente tipoCliente);
	Boolean exluirTipoClientePorChave(Long chave);
	List<TipoCliente> listarTipoClientes();
	List<TipoCliente> pesquisarTipoClientePorNome(String nomeAtributo, String valor);
	TipoCliente pesquisarTipoClientePorChave(Long chave);
}
