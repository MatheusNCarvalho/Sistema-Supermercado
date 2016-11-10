package com.ifgoiano.supermecado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifgoiano.supermecado.model.Categoria;

public interface Categorias extends JpaRepository<Categoria, Long> {
	
	

}
