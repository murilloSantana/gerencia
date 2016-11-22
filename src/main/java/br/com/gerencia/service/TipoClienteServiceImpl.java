package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.TipoClienteDAO;
import br.com.gerencia.model.TipoCliente;

@Service("tipoClienteService")
public class TipoClienteServiceImpl implements TipoClienteService{

	@Autowired
	private TipoClienteDAO tipoClienteDAO;

	public Boolean salvarTipoCliente(TipoCliente tipoCliente) {
			return tipoClienteDAO.salvarTipoCliente(tipoCliente);
		}

		public Boolean editarTipoCliente(TipoCliente tipoCliente) {
			return tipoClienteDAO.editarTipoCliente(tipoCliente);
		}

		public Boolean excluirTipoCliente(TipoCliente tipoCliente) {
			return tipoClienteDAO.excluirTipoCliente(tipoCliente);
		}

		public Boolean exluirTipoClientePorChave(Long chave) {
			return tipoClienteDAO.exluirTipoClientePorChave(chave);
		}

		public List<TipoCliente> listarTipoClientes() {
			return  tipoClienteDAO.listarTipoClientes();
		}

		public List<TipoCliente> pesquisarTipoClientePorNome(String nomeAtributo, String valor) {
			return  tipoClienteDAO.pesquisarTipoClientePorNome(nomeAtributo, valor);
		}

		public TipoCliente pesquisarTipoClientePorChave(Long chave) {
			return tipoClienteDAO.pesquisarTipoClientePorChave(chave);
		}
}
