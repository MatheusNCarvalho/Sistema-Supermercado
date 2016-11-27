package com.ifgoiano.supermecado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Produto;
import com.ifgoiano.supermecado.model.Venda;
import com.ifgoiano.supermecado.repository.ItemVendas;
import com.ifgoiano.supermecado.repository.Produtos;
import com.ifgoiano.supermecado.repository.Vendas;

@Controller
@RequestMapping("/vendas")
public class VendaController {

	
	
@Autowired
private Vendas vendas;

@Autowired 
private Produtos produtos;

@Autowired
private ItemVendas itemVendas;

@RequestMapping("/novo")
public ModelAndView novo(){
	List<Produto> todosProdutos = produtos.findAll();
	ModelAndView mv = new ModelAndView("venda/CadastroVenda");
	mv.addObject("venda",new Venda());
	mv.addObject("produto",todosProdutos);
	return mv;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
