package com.projetoDesafio.bancoApi.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projetoDesafio.bancoApi.controller.form.CadastroForm;

/**
 * @author domenicalif
 *
 */
@Entity
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private Long cpf;
	private Date dataNasc;
	

	public Cliente() {
		
	}
	
	
	public Cliente(String nome, String email, Long cpf, Date dataNasc) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}


	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public Long getCpf() {
		return cpf;
	}
	public Date getDataNasc() {
		return dataNasc;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public static Cliente gerarClienteEntity(CadastroForm cadastroForm) {
		Cliente cliente = new Cliente();
		
		cliente.setCpf(cadastroForm.getCpf());
		cliente.setEmail(cadastroForm.getEmail());
		cliente.setNome(cadastroForm.getNome());
		try {
			cliente.setDataNasc(obterDataFormatada(cadastroForm.getDataNasc()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	private static Date obterDataFormatada(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(data);
	}
	
}
