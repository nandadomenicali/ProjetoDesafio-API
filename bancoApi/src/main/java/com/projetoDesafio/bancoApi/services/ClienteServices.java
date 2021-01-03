package com.projetoDesafio.bancoApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoDesafio.bancoApi.controller.dto.ClienteDto;
import com.projetoDesafio.bancoApi.controller.form.CadastroForm;
import com.projetoDesafio.bancoApi.model.Cliente;
import com.projetoDesafio.bancoApi.repository.CadastroRepository;

@Service
public class ClienteServices {

	@Autowired
	private CadastroRepository cadastroRepository;

	public List<ClienteDto> listarClientes() {
		List<Cliente> cadastros = cadastroRepository.findAll();

		return ClienteDto.converterList(cadastros);
	}

	public ClienteDto cadastrar(CadastroForm cadastroForm) throws Exception {
		List<Cliente> cliente = cadastroRepository.buscarCpfEmailIguais(cadastroForm.getCpf(), cadastroForm.getEmail());

		if (cliente.size() > 0) {
			throw new Exception("CPF ou Email ja cadastrado.");
		}

		Cliente clienteEntity = cadastroRepository.save(Cliente.gerarClienteEntity(cadastroForm));

		return ClienteDto.converter(clienteEntity);

	}

}
