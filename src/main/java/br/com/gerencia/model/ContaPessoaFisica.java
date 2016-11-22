package br.com.gerencia.model;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;
//@Entity
@Component
public class ContaPessoaFisica extends TipoConta {

	private String nome;

	private String sobrenome;

	private Long cpf;

	private Long rg;

	//private Date dataNascimento;

	private String sexo;

}
