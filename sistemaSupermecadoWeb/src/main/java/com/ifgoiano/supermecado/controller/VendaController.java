package com.ifgoiano.supermecado.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Produto;
import com.ifgoiano.supermecado.model.Cliente;
import com.ifgoiano.supermecado.model.ItemCompra;
import com.ifgoiano.supermecado.model.ItemVenda;
import com.ifgoiano.supermecado.model.Venda;
import com.ifgoiano.supermecado.repository.ItemVendas;
import com.ifgoiano.supermecado.repository.Produtos;
import com.ifgoiano.supermecado.repository.Aberturas;
import com.ifgoiano.supermecado.repository.Clientes;
import com.ifgoiano.supermecado.repository.Fechamentos;
import com.ifgoiano.supermecado.repository.Vendas;

@Controller
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private Vendas vendas;

	@Autowired
	private Produtos produtos;

	@Autowired
	private Clientes usuarios;

	@Autowired
	private ItemVendas itemVendas;

	@Autowired
	private Aberturas aberturas;
	
	@Autowired
	private Fechamentos fechamentos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		List<Cliente> todosUsuarios = usuarios.findAll();
		List<Produto> todosProdutos = produtos.findAll();
		ModelAndView mv = new ModelAndView("venda/CadastroVenda");
		mv.addObject("venda", new Venda());
		mv.addObject("cliente", todosUsuarios);
		mv.addObject("produto", todosProdutos);
		String teste = SecurityContextHolder.getContext().getAuthentication().getName();
		boolean condicao=true;
		if (aberturas.find(teste)>fechamentos.find(teste)){
			condicao=false;
			mv.addObject("valorSaldoCaixa",vendas.selectTotalVendas(teste, aberturas.findId(teste)));

		}
		mv.addObject("valorDoCaixa",vendas.selectSaldoCaixa(teste));
		mv.addObject("condicao",condicao);
		System.out.println("Precisa Abrir Modal"+condicao);
		return mv;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody String i) {
		System.out.println(i);

		// Criando uma Venda
		Venda venda = new Venda();

		// Criando um array para salvar os valores
		String array[] = new String[32];

		// Regex
		String regex = "\"(,)\"";

		// Inicia os contadores
		int valorCount = 1;
		int qtdCount = 2;
		int produtoCount = 3;

		// Divide o JSON em um array utilizando a regex que ira separa-lo quando
		// tiver ","
		// e cada elemento sera guardado em uma posição de array
		array = i.split(regex);

		// Utilizando o substring para retirar a parte antes do cliente
		String fkCliente = array[0].substring(6);
		
		//Pegado o usuario logado e setando na variavel
		String teste = (String) SecurityContextHolder.getContext().getAuthentication().getName();
		venda.setUsuario(teste);
		if(fkCliente=="No Match"){
			fkCliente="0";
		}
		//Convertendo e setando o id do cliente e salvando a data da compra
		venda.setFkCliente(Integer.parseInt(fkCliente));
		venda.setDataVenda(venda.getDateTime());
		venda.setFkAbertura(aberturas.findId(teste));
		//Salvando a compra	
		vendas.save(venda);
		
		//Recuperando o id da compra para relacionar com vendas itens
		long fkVenda = venda.getIdVenda();


		for(int o=1;array.length>=o;o++){
			//Utilzando o substring para retirar a parte antes dos valores e com isso poder salvar no banco
			String valorUnitarioString = array[valorCount].substring(7);
			String qtdString = array[qtdCount].substring(7);
			String fkProdutoString = array[produtoCount].substring(7).replace("\"}", "");
			
			//Criando uma nova venda itens
			ItemVenda itens = new ItemVenda();
			
			//Setando os itens e convertendo eles em seus respectivos formatos
			BigDecimal valorUnitario = new BigDecimal(valorUnitarioString);
			itens.setQtd(Integer.parseInt(qtdString));
			itens.setValorUnitario(valorUnitario);
			itens.setFkVenda(fkVenda);
			itens.setFkProduto(Integer.parseInt(fkProdutoString));
			
			//Salvando os itens
			itemVendas.save(itens);
			
			
			//Incrementando o contador de cada atributo de item
			valorCount=valorCount+3;
			qtdCount = qtdCount+3;
			produtoCount = produtoCount +3;
			
		
			//Verificar se quando incrementa o valor do contador para nao ultrapassar o tamanho do array
			if(valorCount>=array.length||qtdCount>=array.length||produtoCount>=array.length){
				break;
			}
		}
		
		return ResponseEntity.ok(HttpStatus.OK);

		
	}
}
