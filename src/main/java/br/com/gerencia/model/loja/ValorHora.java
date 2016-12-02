package br.com.gerencia.model.loja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "valor_hora")
@Component
public class ValorHora {
	@Id
	@GeneratedValue(generator = "valor_hora_seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "valor_hora_seq", sequenceName = "chave_valor_hora_seq", allocationSize = 1)
	@Column(name = "chave_valor_hora")
	private Long chaveValorHora;
	@Column
	private Integer minuto;
	@Column
	private Double preco;
	@Column
	private String modelo;
	@Transient
	private String precoNoFormatado;

	public ValorHora() {
		super();
	}

	public ValorHora(Long chaveValorHora, Integer minuto, Double preco, String modelo) {
		super();
		this.chaveValorHora = chaveValorHora;
		this.minuto = minuto;
		this.preco = preco;
		this.modelo = modelo;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getChaveValorHora() {
		return chaveValorHora;
	}

	public String getPrecoNoFormatado() {
		return precoNoFormatado;
	}

	public void setPrecoNoFormatado(String precoNoFormatado) {
		this.precoNoFormatado = precoNoFormatado;
	}

}
