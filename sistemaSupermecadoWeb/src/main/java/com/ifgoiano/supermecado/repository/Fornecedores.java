package com.ifgoiano.supermecado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ifgoiano.supermecado.model.Fornecedor;

public interface Fornecedores extends JpaRepository<Fornecedor,Long > {

/*	
	@Query("SELECT new Fornecedor(f.idFornecedor,f.nome,f.cnpj,f.telefone) FROM Fornecedor f ")
	List<Fornecedor> consulta();*/
	
	/*@Query("select fe from FornecedorEndereco as fe join fetch fe.fornecedor where fe.fornecedor.idFornecedor = :id")
	FornecedorEndereco findByCodigo(@Param("id") long id);*/
	
	@Query("select count(fo.idFornecedor) from Fornecedor as fo")
	 List<Fornecedor> findByCount();
	
	public Optional<Fornecedor> findByNomeContaining(String nome);
	
	public List<Fornecedor> findByNomeContainingIgnoreCase(String nome);
	
}
