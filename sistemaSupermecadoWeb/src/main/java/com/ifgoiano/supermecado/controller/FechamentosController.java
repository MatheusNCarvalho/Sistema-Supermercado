package com.ifgoiano.supermecado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ifgoiano.supermecado.model.Fechamento;

@Controller
@RequestMapping("/fechamento")
public class FechamentosController {
	
	@RequestMapping("/novo")
	public String novo(){
		return "fechamento";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Fechamento fechamento){
		//TODO: Salvar no banco de dados.
		
		return "fechamento";
	}

}
