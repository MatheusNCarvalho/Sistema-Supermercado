package com.ifgoiano.supermecado.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Compra;
import com.ifgoiano.supermecado.model.Fornecedor;
import com.ifgoiano.supermecado.model.ItemCompra;
import com.ifgoiano.supermecado.model.Produto;
import com.ifgoiano.supermecado.repository.Fornecedores;
import com.ifgoiano.supermecado.repository.ItemCompras;
import com.ifgoiano.supermecado.repository.Produtos;

@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private Fornecedores fos;
	
	@Autowired
	private Produtos produtos;


	@Autowired
	private ItemCompras i;

	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("compra/CadastroVenda");
		mv.addObject("compra",new Compra());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Compra compra, ItemCompra itenss){
		
		List<ItemCompra> itens = new ArrayList<ItemCompra>();
	


		for(ItemCompra item : compra.getItens()){
			if(item.getProduto().getId()!=0 && item.getProduto().getCodigoBarras() != null){
				itens.add(itenss);
			}
			itenss.setCompra(compra);
			i.save(itens);
		}
			
		
		ModelAndView mv = new ModelAndView("compra/CadastroVenda");
		return mv;
	}
	
	
}
