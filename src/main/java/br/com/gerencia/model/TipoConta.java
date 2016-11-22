package br.com.gerencia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Component
public abstract class TipoConta implements Serializable {
	
	private static final long serialVersionUID = 6894924607544126293L;

	@Id
//    @GeneratedValue(strategy=GenerationType.TABLE) 
    @SequenceGenerator(name="generator_tipo_conta", sequenceName="generator")
    @GeneratedValue( generator="generator_tipo_conta") 
	private Long chavePessoa;

	private String apelido;

	private String email;

	private String endereco;

	private String telefone;

	// private PessoaCreator pessoaCreator;


	public PessoaCreator geraPessoaCreator() {
		return null;
	}

	public TipoConta() {
		super();
	}

	public TipoConta(String apelido, String email,
			String endereco, String telefone) {
		super();
		this.apelido = apelido;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getChavePessoa() {
		return chavePessoa;
	}

	public void setChavePessoa(Long chavePessoa) {
		this.chavePessoa = chavePessoa;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
