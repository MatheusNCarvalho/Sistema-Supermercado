package com.ifgoiano.supermecado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifgoiano.supermecado.model.Movimento;

public interface Movimentos extends JpaRepository<Movimento, Long> {
	@Query(value="SELECT SUM(valor) FROM movimentos WHERE fk_abertura = (:abertura) AND tipo='RMV'", nativeQuery=true)
	public Double selectMovimentoRetirada(@Param("abertura")int abertura);
	@Query(value="SELECT SUM(valor) FROM movimentos WHERE fk_abertura = (:abertura) AND tipo='ADD'", nativeQuery=true)
	public Double selectMovimentoAdicionado(@Param("abertura")int abertura);
}
