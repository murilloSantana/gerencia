package br.com.gerencia.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.gerencia.model.Endereco;

@Repository("enderecoDAO")
@Transactional
@SuppressWarnings("unchecked")
public class EnderecoDAOImpl extends AbstractDAO<Long, Endereco> implements EnderecoDAO{

	public Boolean salvarEndereco(Endereco endereco) {
		return super.salvar(endereco);
	}

	public Boolean editarEndereco(Endereco endereco) {
		return super.editar(endereco);
	}

	public Boolean excluirEndereco(Endereco endereco) {
		return super.excluir(endereco);
	}

	public Boolean exluirEnderecoPorChave(Long chave) {
		return super.excluirPorChave(chave);
	}

	public List<Endereco> listarEnderecos() {
		return (List<Endereco>) super.listarTodos();
	}

	public List<Endereco> pesquisarEnderecoPorNome(String nomeAtributo, String valor) {
		return (List<Endereco>) super.pesquisarPorNome(nomeAtributo, valor);
	}

	public Endereco pesquisarEnderecoPorChave(Long chave) {
		return super.pesquisarPorChave(chave);
	}
}
