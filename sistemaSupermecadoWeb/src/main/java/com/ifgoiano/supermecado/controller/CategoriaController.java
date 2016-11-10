package com.ifgoiano.supermecado.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifgoiano.supermecado.model.Categoria;
import com.ifgoiano.supermecado.repository.Categorias;




@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private Categorias categorias;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(){

		ModelAndView mv = new ModelAndView("categoria/CadastroCategoria2");
		mv.addObject(new Categoria());
		return mv;
	}
	
	@RequestMapping(value="/salvar",method = RequestMethod.POST)
	public String salvar(@Validated  Categoria catego,Errors errors,RedirectAttributes attributes){
		if(errors.hasErrors()){
			return "categoria/CadastroCategoria";
		}
		categorias.save(catego);

		attributes.addFlashAttribute("mensagem","Categoria salva com sucesso!");
		return "redirect:/categorias/novo";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Categoria getCategoriaJSON(@Validated @RequestBody Categoria catego,Errors errors,RedirectAttributes attributes){
		// novo objeto para ser convertido em json para enviar pro front
		Categoria cat = new Categoria();
		cat.setDescricao(catego.getDescricao());
		cat.setNome(catego.getNome());
		if(errors.hasErrors()){
			return cat;
		}
		categorias.save(catego);
		
		attributes.addFlashAttribute("mensagem","Categoria salva com sucesso!");
		return cat;
		
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){

		List<Categoria> todosCategoria = categorias.findAll();

		ModelAndView mv = new ModelAndView("categoria/PesquisarCategoria");
		mv.addObject("categorias", todosCategoria);

		return mv;

	}
	@RequestMapping("{id}")
public ModelAndView edicao(@PathVariable("id") Categoria cate){
	ModelAndView mv = new ModelAndView("categoria/CadastroCategoria2");
	mv.addObject(cate);
	return mv;
	}
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		categorias.delete(id);
		attributes.addFlashAttribute("mensagem", "Categoria excluída com sucesso!");
		return "redirect:/categorias";
	}

	@RequestMapping(value="/data/jsonList", method=RequestMethod.GET)
	public @ResponseBody List<Categoria> getDataList() {
		List<Categoria> todosCategoria = categorias.findAll();
	    return todosCategoria;
	}

}
