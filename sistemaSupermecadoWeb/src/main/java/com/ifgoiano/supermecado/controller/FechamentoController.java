package com.ifgoiano.supermecado.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifgoiano.supermecado.model.Fechamento;
import com.ifgoiano.supermecado.repository.Fechamentos;


@Controller
@RequestMapping("/fechamentos")
public class FechamentoController {
	
	@Autowired
	private Fechamentos fechamentos;
	
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody Fechamento fechamento){
		String teste = (String) SecurityContextHolder.getContext().getAuthentication().getName();
		fechamento.setData_fechamento(new Date());
		fechamento.setFuncionario(teste);
		fechamentos.save(fechamento);
		return ResponseEntity.ok(fechamento);
		
}
}