package com.ifgoiano.supermecado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifgoiano.supermecado.model.Categoria;

public interface Categorias extends JpaRepository<Categoria, Long> {
	
	public Optional<Categoria> findByNomeIgnoreCase(String nome);


}
