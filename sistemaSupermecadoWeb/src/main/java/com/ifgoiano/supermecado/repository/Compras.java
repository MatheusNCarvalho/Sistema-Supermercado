package com.ifgoiano.supermecado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifgoiano.supermecado.model.Compra;

public interface Compras extends JpaRepository<Compra, Long>{
	
	@Query(value="SELECT  * FROM fornecedores as f JOIN compras as c ON c.pk_compra=(:id) = f.pk_fornecedor", nativeQuery=true)
	Compra todasCompra(@Param("id")long id);
}
