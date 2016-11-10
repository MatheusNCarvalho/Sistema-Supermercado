package com.ifgoiano.supermecado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Fornecedor;
import com.ifgoiano.supermecado.repository.Fornecedores;
import com.ifgoiano.supermecado.service.CadastroFornecedorService;
import com.ifgoiano.supermecado.service.filtro.FornecedorFiltro;

@Controller
@RequestMapping("/home")
public class HomeController {

		@Autowired
		private Fornecedores fo;
		
		private CadastroFornecedorService cadastroFornecedorService;
	
		@RequestMapping("/index")
		public ModelAndView novo(Fornecedor forne){
						
			ModelAndView mv = new ModelAndView("home/index");
			List<Fornecedor> totalFornecedor = fo.findByCount();
			mv.addObject("totalFornecedor",totalFornecedor);			
			return mv;
		
		}
		
		/*@GetMapping
		public ModelAndView teste(@ModelAttribute("filtro") FornecedorFiltro filtro){
			System.out.println(filtro.getNome());
			///String teste = cadastroFornecedorService.filtrar(filtro.getNome());
			///System.out.println(todosFornecedores);
			ModelAndView mv = new ModelAndView("home/CadastroVenda");
			//mv.addObject("todosFornecedores",todosFornecedores);
			//mv.addObject("filtro", filtro);
			
			return mv;
		}*/
}
