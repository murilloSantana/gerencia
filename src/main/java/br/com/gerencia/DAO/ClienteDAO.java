package br.com.gerencia.DAO;

import java.util.List;

import br.com.gerencia.model.Cliente;

public interface ClienteDAO {

	Boolean salvarCliente(Cliente cliente);
	Boolean editarCliente(Cliente cliente);
	Boolean excluirCliente(Cliente cliente);
	Boolean exluirClientePorChave(Long chave);
	List<Cliente> listarClientes();
	List<Cliente> pesquisarClientePorNome(String nomeAtributo, String valor);
	Cliente pesquisarClientePorChave(Long chave);
}
