package com.ifgoiano.supermecado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifgoiano.supermecado.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	public List<Usuario> findByNomeContainingOrCpfContainingIgnoreCase(String nome, String cpf);

}
