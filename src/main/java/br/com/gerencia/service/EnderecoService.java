package br.com.gerencia.service;

import java.util.List;

import br.com.gerencia.model.Endereco;

public interface EnderecoService {

	Boolean salvarEndereco(Endereco endereco);
	Boolean editarEndereco(Endereco endereco);
	Boolean excluirEndereco(Endereco endereco);
	Boolean exluirEnderecoPorChave(Long chave);
	List<Endereco> listarEnderecos();
	List<Endereco> pesquisarEnderecoPorNome(String nomeAtributo, String valor);
	Endereco pesquisarEnderecoPorChave(Long chave);
}
