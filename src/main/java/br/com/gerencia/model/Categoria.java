package br.com.gerencia.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "categoria")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "chaveCategoria")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5694200691137918111L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categoria_seq")
	@SequenceGenerator(name = "categoria_seq", sequenceName = "chave_categoria_seq", allocationSize = 1)
	@Column(name = "chave_categoria")
	private Long chaveCategoria;
	
	private String nome;

	private String descricao;

//	@ManyToMany(mappedBy = "categorias")
	@ManyToOne(cascade = CascadeType.ALL)
	private Produto produto;

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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chaveCategoria == null) ? 0 : chaveCategoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (chaveCategoria == null) {
			if (other.chaveCategoria != null)
				return false;
		} else if (!chaveCategoria.equals(other.chaveCategoria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [chaveCategoria=" + chaveCategoria + ", nome=" + nome + ", descricao=" + descricao
				+ ", produto=" + produto + "]";
	}



}
