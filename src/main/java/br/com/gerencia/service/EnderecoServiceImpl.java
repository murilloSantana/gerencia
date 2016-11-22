package br.com.gerencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerencia.DAO.EnderecoDAO;
import br.com.gerencia.model.Endereco;

@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	private EnderecoDAO enderecoDAO;

	public Boolean salvarEndereco(Endereco endereco) {
			return enderecoDAO.salvarEndereco(endereco);
		}

		public Boolean editarEndereco(Endereco endereco) {
			return enderecoDAO.editarEndereco(endereco);
		}

		public Boolean excluirEndereco(Endereco endereco) {
			return enderecoDAO.excluirEndereco(endereco);
		}

		public Boolean exluirEnderecoPorChave(Long chave) {
			return enderecoDAO.exluirEnderecoPorChave(chave);
		}

		public List<Endereco> listarEnderecos() {
			return  enderecoDAO.listarEnderecos();
		}

		public List<Endereco> pesquisarEnderecoPorNome(String nomeAtributo, String valor) {
			return  enderecoDAO.pesquisarEnderecoPorNome(nomeAtributo, valor);
		}

		public Endereco pesquisarEnderecoPorChave(Long chave) {
			return enderecoDAO.pesquisarEnderecoPorChave(chave);
		}
}
