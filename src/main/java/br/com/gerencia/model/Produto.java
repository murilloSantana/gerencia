package br.com.gerencia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "produto")
@Component

public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1029806744446886178L;
	
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
	@ManyToMany
	@JoinTable(name = "produto_categoria", joinColumns = { @JoinColumn(name = "chave_produto") }, inverseJoinColumns = {
			@JoinColumn(name = "chave_categoria") })
	private List<Categoria> categorias;
	@OneToMany(mappedBy = "produto", targetEntity = ItemTransacao.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ItemTransacao> itensTransacao;
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
			List<ItemTransacao> itensTransacao, String precoCompraNoFormatado, String precoUnitarioNoFormatado,
			List<Long> categoriaId) {
		super();
		this.nomeProduto = nomeProduto;
		this.codigoBarras = codigoBarras;
		this.precoCompra = precoCompra;
		this.precoUnitario = precoUnitario;
		this.descricaoProduto = descricaoProduto;
		this.infoTecnicas = infoTecnicas;
		this.categorias = categorias;
		this.itensTransacao = itensTransacao;
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

	public List<ItemTransacao> getItensTransacao() {
		return itensTransacao;
	}

	public void setItensTransacao(List<ItemTransacao> itensTransacao) {
		this.itensTransacao = itensTransacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
