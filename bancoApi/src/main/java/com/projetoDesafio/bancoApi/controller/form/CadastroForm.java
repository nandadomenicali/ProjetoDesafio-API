package com.projetoDesafio.bancoApi.controller.form;

public class CadastroForm {

	private String nome;
	private String email;
	private Long cpf;
	private String dataNasc;
	
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public Long getCpf() {
		return cpf;
	}
	public String getDataNasc() {
		return dataNasc;
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
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	} 
	
	
}
