package com.ifgoiano.supermecado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifgoiano.supermecado.model.Fechamento;

public interface Fechamentos extends JpaRepository<Fechamento, Long>{
	@Query(value="SELECT COUNT(*)  FROM fechamentos WHERE funcionario = (:funcionarioId)", nativeQuery=true)
	public int find(@Param("funcionarioId")String funcionarioId);
}