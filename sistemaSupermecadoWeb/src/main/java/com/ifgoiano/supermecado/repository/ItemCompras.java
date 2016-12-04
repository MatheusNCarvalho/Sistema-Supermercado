package com.ifgoiano.supermecado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ifgoiano.supermecado.model.ItemCompra;

public interface ItemCompras extends JpaRepository<ItemCompra, Long>{
	
	@Query(value="SELECT  * FROM compras as c JOIN compras_itens as ci on c.pk_compra = ci.fk_compra  JOIN produtos as p ON ci.fk_produto = p.pk_produtos WHERE c.pk_compra = (:id)", nativeQuery=true)
	List<ItemCompra> todasCompra(@Param("id")long id);
	
}
