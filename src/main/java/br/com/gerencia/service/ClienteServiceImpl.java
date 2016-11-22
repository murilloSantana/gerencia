package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.ClienteDAO;
import br.com.gerencia.model.Cliente;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDAO clienteDAO;

	public Boolean salvarCliente(Cliente cliente) {
			return clienteDAO.salvarCliente(cliente);
		}

		public Boolean editarCliente(Cliente cliente) {
			return clienteDAO.editarCliente(cliente);
		}

		public Boolean excluirCliente(Cliente cliente) {
			return clienteDAO.excluirCliente(cliente);
		}

		public Boolean exluirClientePorChave(Long chave) {
			return clienteDAO.exluirClientePorChave(chave);
		}

		public List<Cliente> listarClientes() {
			return  clienteDAO.listarClientes();
		}

		public List<Cliente> pesquisarClientePorNome(String nomeAtributo, String valor) {
			return  clienteDAO.pesquisarClientePorNome(nomeAtributo, valor);
		}

		public Cliente pesquisarClientePorChave(Long chave) {
			return clienteDAO.pesquisarClientePorChave(chave);
		}
}
