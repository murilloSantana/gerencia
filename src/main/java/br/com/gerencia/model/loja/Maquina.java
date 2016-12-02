package br.com.gerencia.model.loja;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "maquina")
@Component
public class Maquina implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4345006744925292974L;
	@Id
	@GeneratedValue(generator = "maquina_seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "maquina_seq", sequenceName = "chave_maquina_seq", allocationSize = 1)
	private Long chaveMaquina;
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "modelo")
	private String modelo;

	public Maquina() {
		super();
	}

	public Maquina(Long chaveMaquina, Integer numero, String modelo) {
		super();
		this.chaveMaquina = chaveMaquina;
		this.numero = numero;
		this.modelo = modelo;
	}

	public Long getChaveMaquina() {
		return chaveMaquina;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
