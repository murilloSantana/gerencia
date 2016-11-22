package br.com.gerencia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "conta_usuario", schema = "schema_conta")
public class ContaUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chaveConta;

	private String nome;

	private String sobrenome;

	private Date dataNascimento;

	private String username;

	private String password;

	private String email;

	private Boolean isAtiva;

	private String schema;

	public Long getChaveConta() {
		return chaveConta;
	}

	public void setChaveConta(Long chaveConta) {
		this.chaveConta = chaveConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAtiva() {
		return isAtiva;
	}

	public void setIsAtiva(Boolean isAtiva) {
		this.isAtiva = isAtiva;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

}
