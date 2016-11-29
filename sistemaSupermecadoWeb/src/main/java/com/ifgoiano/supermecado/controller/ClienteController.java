package com.ifgoiano.supermecado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifgoiano.supermecado.model.Fornecedor;
import com.ifgoiano.supermecado.model.Produto;
import com.ifgoiano.supermecado.model.Cliente;
import com.ifgoiano.supermecado.repository.Clientes;
import com.ifgoiano.supermecado.service.exception.FornecedorNomeJaCadastradoException;
import com.ifgoiano.supermecado.service.filtro.FornecedorFiltro;

@Controller
@RequestMapping("/usuarios")
public class ClienteController {
	
	
	@Autowired
	private Clientes usuarios;
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");	
		mv.addObject("usuario", new Cliente());			
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Cliente usuario,Errors errors,RedirectAttributes attributes){
		if(errors.hasErrors()){
			return "usuario/CadastroUsuario";
		}
		
		try{
			if(usuario.getIdUsuario() !=0){
				usuarios.save(usuario);
				attributes.addFlashAttribute("mensagem", "Usuario Atualizado com sucesso!");
				return "redirect:/usuarios/novo";
			}else
			{
				usuarios.save(usuario);
				attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!");
				//return "redirect:/fornecedores/novo";
			}
			return "redirect:/usuarios/novo";
			
		}catch(FornecedorNomeJaCadastradoException e ){
			errors.rejectValue("nome", e.getMessage(),e.getMessage());
			return "usuario/CadastroUsuario";
		}
		
		
		
	}
	
	public List<Cliente> filtrar(FornecedorFiltro filtro){
		String consulta = filtro.getNome();
		
		return usuarios.findByNomeContainingOrCpfContainingIgnoreCase(consulta,consulta);
	}
	@RequestMapping

	public ModelAndView pesquisar(@ModelAttribute("filtro") FornecedorFiltro filtro) {

		List<Cliente> todosUsuario = filtrar(filtro);
		ModelAndView mv = new ModelAndView("usuario/PesquisaUsuario");
		mv.addObject("usuarios",todosUsuario);
		return mv;

	}
	
	@RequestMapping("{codigo}")//Aqui estamos recebemos o valor da variavel que vem da view
	public ModelAndView edicao(@PathVariable Long codigo ){//declaramos o @pathvariable + mais uma variavel para que possamos receber o valor
														// e trabalhamos com ela
	   //estamos recuperando o codigo do bando de dados
	    Cliente usuario = usuarios.findOne(codigo);
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject(usuario);//passamos o que recuperamos para a view
		return mv;
		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		usuarios.delete(id);

		attributes.addFlashAttribute("mensagem", "Usuario excluído com sucesso!");
		return "redirect:/usuarios";

	}
	
}
