package com.ifgoiano.supermecado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifgoiano.supermecado.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> findByNomeContainingOrCpfContainingIgnoreCase(String nome, String cpf);

}
