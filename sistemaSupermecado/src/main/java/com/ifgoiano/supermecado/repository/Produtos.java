package com.ifgoiano.supermecado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifgoiano.supermecado.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {
	
	
/*	 @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?0", nativeQuery = true)
	  User findByEmailAddress(String emailAddress);*/
	@Query(value="SELECT p.codigo, p.nome FROM produto p", nativeQuery=true)
	Produto consulta(); 
}
