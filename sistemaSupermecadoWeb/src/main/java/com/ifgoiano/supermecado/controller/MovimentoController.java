package com.ifgoiano.supermecado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifgoiano.supermecado.model.Movimento;
import com.ifgoiano.supermecado.repository.Aberturas;
import com.ifgoiano.supermecado.repository.Movimentos;




@Controller
@RequestMapping("/movimentos")
public class MovimentoController {

@Autowired	
private Movimentos movimentos;

@Autowired
private Aberturas aberturas;
	
	
@RequestMapping("/adicionar")
public @ResponseBody ResponseEntity<?> adicionar(@RequestBody Movimento movimento){
	String teste = SecurityContextHolder.getContext().getAuthentication().getName();
	System.out.println(movimento.getValor());
	movimento.setTipo("ADD");
	movimento.setFkAbertura(aberturas.findId(teste));
	System.out.println(movimento.toString());
	movimentos.save(movimento);
	return ResponseEntity.ok(movimento);
}
@RequestMapping("/retirar")
public @ResponseBody ResponseEntity<?> retirar(@RequestBody Movimento movimento){
	String teste = SecurityContextHolder.getContext().getAuthentication().getName();
	System.out.println(movimento.getValor());
	movimento.setTipo("RMV");
	movimento.setFkAbertura(aberturas.findId(teste));
	movimentos.save(movimento);
	return ResponseEntity.ok(movimento);
}
}
