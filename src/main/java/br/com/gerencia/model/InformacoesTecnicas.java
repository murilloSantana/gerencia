package br.com.gerencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "informacoes_tecnicas")
@Component
public class InformacoesTecnicas{

	@Id
	@GeneratedValue(generator = "info_tecnica_seq", strategy = GenerationType.IDENTITY)
	@Column(name = "chave_info_tecnica")
	@SequenceGenerator(name = "info_tecnica_seq", sequenceName = "chave_info_tecnica_seq", allocationSize = 1)
	private Long chaveInfoTecnica;
	@Column(name = "cor")
	private String cor;
	@Column(name = "fabricante")
	private String fabricante;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "mais_informacoes")
	private String maisInformacoes;
	@Column(name = "garantia_fornecedor")
	private String garantiaFornecedor;


	public InformacoesTecnicas(Long chaveInfoTecnica, String cor, String fabricante, String modelo,
			String maisInformacoes, String garantiaFornecedor) {
		super();
		this.chaveInfoTecnica = chaveInfoTecnica;
		this.cor = cor;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.maisInformacoes = maisInformacoes;
		this.garantiaFornecedor = garantiaFornecedor;
	}

	public InformacoesTecnicas() {
		super();
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMaisInformacoes() {
		return maisInformacoes;
	}

	public void setMaisInformacoes(String maisInformacoes) {
		this.maisInformacoes = maisInformacoes;
	}

	public String getGarantiaFornecedor() {
		return garantiaFornecedor;
	}

	public void setGarantiaFornecedor(String garantiaFornecedor) {
		this.garantiaFornecedor = garantiaFornecedor;
	}

	public Long getChaveInfoTecnica() {
		return chaveInfoTecnica;
	}

}
