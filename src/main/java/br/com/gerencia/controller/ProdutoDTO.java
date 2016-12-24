package br.com.gerencia.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.gerencia.model.InformacoesTecnicas;
import br.com.gerencia.model.ItemTransacao;
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class ProdutoDTO {

	private Long chaveProduto;
	private String nomeProduto;
	private Long codigoBarras;
	private Double precoCompra;
	private Double precoUnitario;
	private String descricaoProduto;
	private InformacoesTecnicas infoTecnicas;
	private List<ItemTransacao> itensTransacao;
	private String precoCompraNoFormatado;
	private String precoUnitarioNoFormatado;
	private List<Long> categoriaId;
	private int id;
	
	

	public ProdutoDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getChaveProduto() {
		return chaveProduto;
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

	public List<Long> getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(List<Long> categoriaId) {
		this.categoriaId = categoriaId;
	}

}
