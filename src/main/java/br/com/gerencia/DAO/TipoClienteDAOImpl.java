package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.TipoCliente;

@Repository("tipoClienteDAO")
@Transactional
@SuppressWarnings("unchecked")
public class TipoClienteDAOImpl extends AbstractDAO<Long, TipoCliente> implements TipoClienteDAO{

	public Boolean salvarTipoCliente(TipoCliente tipoCliente) {
		return super.salvar(tipoCliente);
	}

	public Boolean editarTipoCliente(TipoCliente tipoCliente) {
		return super.editar(tipoCliente);
	}

	public Boolean excluirTipoCliente(TipoCliente tipoCliente) {
		return super.excluir(tipoCliente);
	}

	public Boolean exluirTipoClientePorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<TipoCliente> listarTipoClientes() {
		return (List<TipoCliente>) super.listarTodos();
	}

	public List<TipoCliente> pesquisarTipoClientePorNome(String nomeAtributo, String valor) {
		return (List<TipoCliente>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public TipoCliente pesquisarTipoClientePorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
