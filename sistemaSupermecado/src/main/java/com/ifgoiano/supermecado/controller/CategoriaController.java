package com.ifgoiano.supermecado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Categoria;
import com.ifgoiano.supermecado.repository.Categorias;



@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private Categorias categorias;
	
	@RequestMapping("/novo")
	public String novo(){
		
		return"CadastroCategoria2";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Categoria catego){
		
		categorias.save(catego);
		ModelAndView mv = new ModelAndView("CadastroCategoria2");	
		mv.addObject("mensagem", "A operação foi completa com sucesso");
		return mv;
		
	}

}
