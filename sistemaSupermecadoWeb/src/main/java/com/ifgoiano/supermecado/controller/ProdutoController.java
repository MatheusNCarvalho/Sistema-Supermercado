
package com.ifgoiano.supermecado.controller;

import java.util.Arrays;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.validation.Errors;

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifgoiano.supermecado.model.Categoria;

import com.ifgoiano.supermecado.model.Produto;

import com.ifgoiano.supermecado.repository.Categorias;

import com.ifgoiano.supermecado.repository.Produtos;

@Controller

@RequestMapping("/produtos")
public class ProdutoController {

	private static final String CADASTRO_VIEW = "produto/CadastroProduto";

	@Autowired

	private Produtos produtos;

	@Autowired

	private Categorias categorias;

	@RequestMapping("/novo")

	public ModelAndView novo() {

		List<Categoria> todosCategoria = categorias.findAll();

		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);

		mv.addObject("categorias", todosCategoria);
		mv.addObject(new Produto());
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST)

	public String salvar(@Validated Produto prod, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {

			return CADASTRO_VIEW;

		}

		produtos.save(prod);
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");

		return "redirect:/produtos/novo";

	}

	@RequestMapping

	public ModelAndView pesquisar() {

		List<Produto> todosProduto = produtos.findAll();

		ModelAndView mv = new ModelAndView("produto/PesquisarProduto");

		mv.addObject("produtos", todosProduto);

		return mv;

	}

	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Produto prod) {

		List<Categoria> todosCategoria = categorias.findAll();

		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);

		mv.addObject("categorias", todosCategoria);

		mv.addObject(prod);

		return mv;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		produtos.delete(id);

		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
		return "redirect:/produtos";
	}
}