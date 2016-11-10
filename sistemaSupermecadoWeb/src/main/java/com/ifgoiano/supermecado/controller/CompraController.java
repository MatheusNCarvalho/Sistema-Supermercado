package com.ifgoiano.supermecado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Compra;
import com.ifgoiano.supermecado.model.Fornecedor;
import com.ifgoiano.supermecado.model.Produto;
import com.ifgoiano.supermecado.repository.Fornecedores;
import com.ifgoiano.supermecado.repository.Produtos;

@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private Fornecedores fos;
	
	@Autowired
	private Produtos produtos;

	@RequestMapping("/novo")
	public ModelAndView novo(){
		List<Fornecedor> fo = fos.findAll();
		List<Produto> produto = produtos.findAll();	
		
		ModelAndView mv = new ModelAndView("compra/CadastroVenda");
		mv.addObject("fornecedores",fo);
		mv.addObject("produtos",produto);
		mv.addObject("compra", new Compra());
		mv.addObject("fornecedor", new Fornecedor());
		return mv;
	}
	
	
	
}
