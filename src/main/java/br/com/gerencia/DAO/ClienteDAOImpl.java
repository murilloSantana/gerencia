package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Cliente;

@Repository("clienteDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ClienteDAOImpl extends AbstractDAO<Long, Cliente> implements
		ClienteDAO {
	public Boolean salvarCliente(Cliente cliente) {
		return super.salvar(cliente);
	}

	public Boolean editarCliente(Cliente cliente) {
		return super.editar(cliente);
	}

	public Boolean excluirCliente(Cliente cliente) {
		return super.excluir(cliente);
	}

	public Boolean exluirClientePorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Cliente> listarClientes() {
		return (List<Cliente>) super.listarTodos();
	}

	public List<Cliente> pesquisarClientePorNome(String nomeAtributo,
			String valor) {
		return (List<Cliente>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Cliente pesquisarClientePorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
