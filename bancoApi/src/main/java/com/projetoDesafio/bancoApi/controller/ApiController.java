package com.projetoDesafio.bancoApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.projetoDesafio.bancoApi.controller.dto.CadastroDto;
import com.projetoDesafio.bancoApi.controller.dto.ClienteDto;
import com.projetoDesafio.bancoApi.controller.form.CadastroForm;
import com.projetoDesafio.bancoApi.services.ClienteServices;
 
@RestController
public class ApiController {
	
	@Autowired
	private ClienteServices clienteServices;
	
	@GetMapping("clientes")
	public 	List<ClienteDto> listarClientes() {
		List<ClienteDto> clientes = clienteServices.listarClientes();
		 		
		return clientes;	
		
	}

	@PostMapping("cadastrar")
	public ResponseEntity<CadastroDto> cadastrar (@RequestBody CadastroForm form){
		ClienteDto cliente = new ClienteDto();
		CadastroDto cadastroDto = new CadastroDto();
		
		try {
			cliente = clienteServices.cadastrar(form);
			
			cadastroDto.setStatusCode(HttpStatus.CREATED.value());
			cadastroDto.setMensagem(HttpStatus.CREATED.name());
			cadastroDto.setBody(cliente);
			
		} catch (Exception e) {
			cadastroDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
			cadastroDto.setMensagem(e.getMessage());
			
		}

		return ResponseEntity.status(cadastroDto.getStatusCode()).body(cadastroDto);
	}
	
	
		

}
	




