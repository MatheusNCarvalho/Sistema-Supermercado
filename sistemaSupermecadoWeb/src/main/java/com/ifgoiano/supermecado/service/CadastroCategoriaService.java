package com.ifgoiano.supermecado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifgoiano.supermecado.model.Categoria;
import com.ifgoiano.supermecado.repository.Categorias;
import com.ifgoiano.supermecado.service.exception.NomeCategoriaJaCadastradoException;

@Service
public class CadastroCategoriaService {
	
@Autowired
private Categorias categorias;

@Transactional
public Categoria salvar(Categoria categoria){
	Optional<Categoria> categoriaOptional = categorias.findByNomeIgnoreCase(categoria.getNome());
	if(categoriaOptional.isPresent()){
		throw new NomeCategoriaJaCadastradoException("Nome do categoria já cadastrado"); 
	}
	
	return categorias.saveAndFlush(categoria);
}
}
