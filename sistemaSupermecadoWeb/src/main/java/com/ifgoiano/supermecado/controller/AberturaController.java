package com.ifgoiano.supermecado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifgoiano.supermecado.model.Abertura;
import com.ifgoiano.supermecado.repository.Aberturas;





@Controller
@RequestMapping("/aberturas")
public class AberturaController {
	
	@Autowired
	private Aberturas aberturas;
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody Abertura abertura){
		String teste = (String) SecurityContextHolder.getContext().getAuthentication().getName();
		abertura.setDataVenda(abertura.getDateTime());
		abertura.setFuncionario(teste);
		aberturas.save(abertura);
		return ResponseEntity.ok(abertura);
	}
}
