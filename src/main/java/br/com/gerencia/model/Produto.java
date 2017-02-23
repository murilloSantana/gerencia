package br.com.gerencia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "produto")
@Component
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "chaveProduto")
public class Produto{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "produto_seq")
	@SequenceGenerator(name = "produto_seq", sequenceName = "chave_produto_seq", allocationSize = 1)
	@Column(name = "chave_produto")
	private Long chaveProduto;
	@Column(name = "nome_produto")
	private String nomeProduto;
	@Column(name = "codigo_barras")
	private Long codigoBarras;
	@Column(name = "preco_compra")
	private Double precoCompra;
	@Column(name = "preco_unitario")
	private Double precoUnitario;
	@Column(name = "descricao_produto")
	private String descricaoProduto;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "chave_info_tecnicas")
	private InformacoesTecnicas infoTecnicas;
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name = "produto_categoria", joinColumns = { @JoinColumn(name = "chave_produto") }, inverseJoinColumns = {
//			@JoinColumn(name = "chave_categoria") })
	@OneToMany(mappedBy = "produto", targetEntity = Categoria.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JsonIgnore
	private List<Categoria> categorias;
//	@OneToMany(mappedBy = "produto", targetEntity = ItemTransacao.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Transient
	private String precoCompraNoFormatado;
	@Transient
	private String precoUnitarioNoFormatado;
	// private TipoProduto tipoProduto;
	@Transient
	private List<Long> categoriaId;
	// private Unidade unidade;

	// private Fornecedor fornecedor;

	public Produto() {
		super();
	}

	public Produto(String nomeProduto, Long codigoBarras, Double precoCompra, Double precoUnitario,
			String descricaoProduto, InformacoesTecnicas infoTecnicas, List<Categoria> categorias,
			String precoCompraNoFormatado, String precoUnitarioNoFormatado, List<Long> categoriaId) {
		super();
		this.nomeProduto = nomeProduto;
		this.codigoBarras = codigoBarras;
		this.precoCompra = precoCompra;
		this.precoUnitario = precoUnitario;
		this.descricaoProduto = descricaoProduto;
		this.infoTecnicas = infoTecnicas;
		this.categorias = categorias;
		this.precoCompraNoFormatado = precoCompraNoFormatado;
		this.precoUnitarioNoFormatado = precoUnitarioNoFormatado;
		this.categoriaId = categoriaId;
	}

	public void setChaveProduto(Long chaveProduto) {
		this.chaveProduto = chaveProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getPrecoCompraNoFormatado() {
		return precoCompraNoFormatado;
	}

	public void setPrecoCompraNoFormatado(String precoCompraNoFormatado) {
		this.precoCompraNoFormatado = precoCompraNoFormatado;
	}

	public String getPrecoUnitarioNoFormatado() {
		return precoUnitarioNoFormatado;
	}

	public void setPrecoUnitarioNoFormatado(String precoUnitarioNoFormatado) {
		this.precoUnitarioNoFormatado = precoUnitarioNoFormatado;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Long> getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(List<Long> categoriaId) {
		this.categoriaId = categoriaId;
	}

	public InformacoesTecnicas getInfoTecnicas() {
		return infoTecnicas;
	}

	public void setInfoTecnicas(InformacoesTecnicas infoTecnicas) {
		this.infoTecnicas = infoTecnicas;
	}

	public Long getChaveProduto() {
		return chaveProduto;
	}

	@Override
	public String toString() {
		return "Produto [chaveProduto=" + chaveProduto + ", nomeProduto=" + nomeProduto + ", codigoBarras="
				+ codigoBarras + ", precoCompra=" + precoCompra + ", precoUnitario=" + precoUnitario
				+ ", descricaoProduto=" + descricaoProduto + ", infoTecnicas=" + infoTecnicas + ", categorias="
				+ categorias + ", precoCompraNoFormatado=" + precoCompraNoFormatado + ", precoUnitarioNoFormatado="
				+ precoUnitarioNoFormatado + ", categoriaId=" + categoriaId + "]";
	}



}
