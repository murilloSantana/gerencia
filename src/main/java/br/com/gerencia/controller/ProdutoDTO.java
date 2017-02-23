package br.com.gerencia.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.InformacoesTecnicas;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "chaveProduto")
public class ProdutoDTO {

	private Long chaveProduto;
	private String nomeProduto;
	private Long codigoBarras;
	private Double precoCompra;
	private Double precoUnitario;
	private String descricaoProduto;
	private InformacoesTecnicas infoTecnicas;
	private List<CategoriaDTO> categorias;
	private String precoCompraNoFormatado;
	private String precoUnitarioNoFormatado;
	private List<Long> categoriaId;
	// private Unidade unidade;

	// private Fornecedor fornecedor;

	public ProdutoDTO() {
		super();
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

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
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



}
