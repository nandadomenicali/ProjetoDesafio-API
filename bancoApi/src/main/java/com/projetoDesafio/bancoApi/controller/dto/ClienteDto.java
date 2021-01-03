package com.projetoDesafio.bancoApi.controller.dto;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.projetoDesafio.bancoApi.model.Cliente;


public class ClienteDto {
	
	private Long id;
	private String nome;
	private String email;
	private Long cpf;
	private String dataNasc;
	
	public ClienteDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteDto(Cliente cadastro) {
		this.id = cadastro.getId();
		this.nome = cadastro.getNome();
		this.email = cadastro.getEmail();
		this.cpf = cadastro.getCpf();
		this.dataNasc = obterDataFormatada(cadastro.getDataNasc());
	}
	
	public static String obterDataFormatada(Date dataNasc){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dataNasc);
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
	public String getDataNasc() {
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

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public static List<ClienteDto> converterList(List<Cliente> cliente){
		return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

	public static ClienteDto converter(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		
		clienteDto.setId(cliente.getId());
		clienteDto.setNome(cliente.getNome());
		clienteDto.setCpf(cliente.getCpf());
		clienteDto.setEmail(cliente.getEmail());
		clienteDto.setDataNasc(obterDataFormatada(cliente.getDataNasc()));
		
		return clienteDto;
	}
	
}
