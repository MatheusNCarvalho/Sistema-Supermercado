package com.ifgoiano.supermecado.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.ifgoiano.supermecado.model.FinanceiroEntrada;
import com.ifgoiano.supermecado.model.ItemCompra;
import com.ifgoiano.supermecado.model.ItemVenda;
import com.ifgoiano.supermecado.model.Venda;
import com.ifgoiano.supermecado.repository.ItemVendas;
import com.ifgoiano.supermecado.repository.Movimentos;
import com.ifgoiano.supermecado.repository.Produtos;
import com.ifgoiano.supermecado.repository.Aberturas;
import com.ifgoiano.supermecado.repository.Clientes;
import com.ifgoiano.supermecado.repository.Fechamentos;
import com.ifgoiano.supermecado.repository.FinanceiroEntradas;
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
	private Movimentos movimentos;	
	
	@Autowired
	private Fechamentos fechamentos;
	
	@Autowired
	private FinanceiroEntradas financeiroEntradas;
	
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
		Double removido= movimentos.selectMovimentoRetirada(aberturas.find(teste));
		Double adicionado=movimentos.selectMovimentoAdicionado(aberturas.find(teste));
		if (removido==null){
			removido=0.00;
		}
		if(adicionado==null){
			adicionado=0.00;
		}
		Double saldoParcial=vendas.selectSaldoCaixa(teste);
		System.out.println("Adicionado:"+adicionado);
		System.out.println("Removido:"+removido);
		System.out.println("Saldo Parcial:"+saldoParcial);
		Double TotalCaixa=saldoParcial-removido+adicionado;
		mv.addObject("valorDoCaixa",TotalCaixa);
		mv.addObject("retirada",removido);
		mv.addObject("condicao",condicao);
		System.out.println("Precisa Abrir Modal"+condicao);
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		
		List<Venda> todasVendas = vendas.findAll();
		//List<Venda> todosValores = vendas.todosValores();
		
		ModelAndView mv = new ModelAndView("venda/PesquisaVendas");
		mv.addObject("todasVendas",todasVendas);
		//mv.addObject("todosValores",todosValores);
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
		Date dataSistema = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataSistemaStr = formater.format(dataSistema);
		try {
			java.sql.Date dataSistemaDate = new java.sql.Date(formater.parse(dataSistemaStr).getTime());
			venda.setDataVenda(dataSistemaDate);
			System.out.println(">>>"+dataSistemaDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		FinanceiroEntrada finaceiroEntrada = new FinanceiroEntrada();
		String array2[]= new String[32];
		// array2[0] salva quantidade de vezes e array2[1] salva o valor de cada
		array2=array[array.length-1].substring(5).replace("\"}", "").split("x");
		System.out.println("valor"+array2[1]);
		System.out.println("Parcelas"+array2[0]);
		Date dataSistemaDate= new Date();
			int parcela = Integer.parseInt(array2[0]);
			Double valor = Double.parseDouble(array2[1]);
			if(parcela==0){
				finaceiroEntrada.setDataEmissao(dataSistemaDate);
				finaceiroEntrada.setDataVencimento(dataSistemaDate);
				finaceiroEntrada.setDataBaixa(dataSistemaDate);
				finaceiroEntrada.setFkVenda(fkVenda);
				finaceiroEntrada.setValor(valor);
				financeiroEntradas.save(finaceiroEntrada);
			}
			else{
				System.out.println("dentro");
				for(int contador=1;contador<=parcela;contador++){
					FinanceiroEntrada finaceiroEntradaLoop = new FinanceiroEntrada();
					Calendar c = Calendar.getInstance();
					c.setTime(dataSistemaDate);
					c.set(Calendar.MONTH,c.get(Calendar.MONTH)+contador);
					System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
					finaceiroEntradaLoop.setDataEmissao(dataSistemaDate);
					finaceiroEntradaLoop.setDataVencimento(c.getTime());
					finaceiroEntradaLoop.setFkVenda(fkVenda);
					finaceiroEntradaLoop.setValor(valor);
					financeiroEntradas.save(finaceiroEntradaLoop);

				}
			}
		
			
		
	
		return ResponseEntity.ok(HttpStatus.OK);

		
	}
}
