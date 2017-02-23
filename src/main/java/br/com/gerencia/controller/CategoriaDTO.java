package br.com.gerencia.controller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "chaveCategoria")
public class CategoriaDTO {

	private Long chaveCategoria;

	private String nome;

	private String descricao;

	private ProdutoDTO produto;
	
	public Long getChaveCategoria() {
		return chaveCategoria;
	}

	public void setChaveCategoria(Long chaveCategoria) {
		this.chaveCategoria = chaveCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	
}
