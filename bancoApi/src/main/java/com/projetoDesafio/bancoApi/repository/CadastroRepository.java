package com.projetoDesafio.bancoApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projetoDesafio.bancoApi.model.Cliente;

public interface CadastroRepository extends JpaRepository<Cliente, Long> {
	
	@Query(value = "SELECT c FROM Cliente c WHERE CPF = :cpf OR EMAIL = :email")
	public List<Cliente> buscarCpfEmailIguais(Long cpf, String email);

}
