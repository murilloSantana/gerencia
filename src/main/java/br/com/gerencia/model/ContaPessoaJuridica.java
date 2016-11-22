package br.com.gerencia.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

//@Entity
@Component
public class ContaPessoaJuridica extends TipoConta {

	
	private static final long serialVersionUID = 5723766538301492710L;

	private String razaoSocial;

	private Long cnpj;

	public ContaPessoaJuridica() {
		super();
	}

	public ContaPessoaJuridica(String apelido, String email, String endereco,
			String telefone, String razaoSocial, Long cnpj) {
		super(apelido, email, endereco, telefone);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

}
