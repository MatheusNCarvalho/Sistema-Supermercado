package com.ifgoiano.supermecado.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ifgoiano.supermecado.model.Abertura;

public interface Aberturas extends JpaRepository<Abertura, Long	> {
	

	@Query(value="SELECT COUNT(*)  FROM aberturas WHERE funcionario = (:funcionarioId)", nativeQuery=true)
	public int find(@Param("funcionarioId")String funcionarioId);
}
