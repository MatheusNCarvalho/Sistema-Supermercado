package com.ifgoiano.supermecado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ifgoiano.supermecado.model.Fornecedor;

public interface Fornecedores extends JpaRepository<Fornecedor,Long > {

	
	@Query("SELECT new Fornecedor(f.nome,f.cnpj) FROM Fornecedor f ")
	List<Fornecedor> consulta();
	
}
