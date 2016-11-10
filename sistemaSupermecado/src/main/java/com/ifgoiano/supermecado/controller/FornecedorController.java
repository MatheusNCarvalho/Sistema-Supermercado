package com.ifgoiano.supermecado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Fornecedor;
import com.ifgoiano.supermecado.model.FornecedorEndereco;
import com.ifgoiano.supermecado.model.Produto;
import com.ifgoiano.supermecado.repository.Fornecedores;
import com.ifgoiano.supermecado.repository.FornecedoresEnderecos;



@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private Fornecedores forne;
	
	@Autowired
	private FornecedoresEnderecos fornEnd;
	
	
	@RequestMapping("/novo")
	public String novo(){
		
		return"CadastroFornecedor";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Fornecedor fornece, FornecedorEndereco forneEdn){
		//funci.setFuncEnd(end);
		//func.save(funci);
		forneEdn.setFornecedor(fornece);
		fornEnd.save(forneEdn);
		
		ModelAndView mv = new ModelAndView("CadastroFornecedor");
		mv.addObject("mensagem", "Funcionario salvo com sucesso!");
		return mv;
		
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List<Fornecedor> todosFornecedores = forne.consulta();
		ModelAndView mv = new ModelAndView("PesquisaFornecedor");
		mv.addObject("fornecedores", todosFornecedores);
		return mv;
	}
	

}
