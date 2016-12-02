package br.com.gerencia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1726399609794699389L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categoria_seq")
	@SequenceGenerator(name = "categoria_seq", sequenceName = "chave_categoria_seq", allocationSize = 1)
	@Column(name = "chave_categoria")
	private Long chaveCategoria;

	private String nome;

	private String descricao;
	
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos;

	public Categoria() {
		super();
	}

	public Categoria(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
