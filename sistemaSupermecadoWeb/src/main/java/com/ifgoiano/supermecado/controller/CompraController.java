package com.ifgoiano.supermecado.controller;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifgoiano.supermecado.model.Compra;
import com.ifgoiano.supermecado.model.Fornecedor;
import com.ifgoiano.supermecado.model.ItemCompra;
import com.ifgoiano.supermecado.model.Produto;
import com.ifgoiano.supermecado.repository.Compras;
import com.ifgoiano.supermecado.repository.Fornecedores;
import com.ifgoiano.supermecado.repository.ItemCompras;
import com.ifgoiano.supermecado.repository.Produtos;



@Controller
@RequestMapping("/compras")
public class CompraController {
	

	
	@Autowired
	private Compras compras;
	
	@Autowired
	private Fornecedores fornecedores;
	
	@Autowired Produtos produtos;
	
	@Autowired
	private ItemCompras is;

	@RequestMapping("/novo")
	public ModelAndView novo(){
		List<Fornecedor> todosFornecedores = fornecedores.findAll();
		List<Produto> todosProdutos = produtos.findAll();
		ModelAndView mv = new ModelAndView("compra/CadastroVenda");
		mv.addObject("compra",new Compra());
		mv.addObject("produto",todosProdutos);
		mv.addObject("fornecedor", todosFornecedores);
		return mv;
		
		
	}
	
	@RequestMapping(value="/salvar",method = RequestMethod.POST)
	public ResponseEntity<?> salvar(@RequestBody String i){
		System.out.println(i);
		
		//Criando uma nova compra
		Compra compra = new Compra();
		
		//Criar um novo array
		String array[] = new String[32];
		
		//Regex com a condição de ","
		String regex = "\"(,)\"";
		
		//Inicia um contador para usar no array onde os item virao na msm sequencia
		int valorCount=1;
		int qtdCount=2;
		int produtoCount=3;
		
		//Divide o JSON em um array utilizando a regex que ira separa-lo quando tiver "," 
		//e cada elemento sera guardado em uma posição de array
		array = i.split(regex);
				//Utilizando o substring para retirar a parte antes do fornecedor
				String fkfornecedor = array[0].substring(6);
				
				//Convertendo e setando o id do fornecedor e salvando a data da compra
				compra.setFkFornecedor(Integer.parseInt(fkfornecedor));
				compra.setDataDaCompra(compra.getDateTime());
				
				//Salvando a compra
				compras.save(compra);
				//Recuperando o id da compra para relacionar com compras itens
				long fkCompra = compra.getIdCompra();
		

		for(int o=1;array.length>=o;o++){
			//Utilzando o substring para retirar a parte antes dos valores e com isso poder salvar no banco
			String valorUnitarioString = array[valorCount].substring(7);
			String qtdString = array[qtdCount].substring(7);
			String fkProdutoString = array[produtoCount].substring(7).replace("\"}", "");
	

			//Criando uma nova compra itens
			ItemCompra itens = new ItemCompra();
			
			//Setando os itens e convertendo eles em seus respectivos formatos
			BigDecimal valorUnitario = new BigDecimal(valorUnitarioString);
			itens.setQtd(Integer.parseInt(qtdString));
			itens.setValorUnitario(valorUnitario);
			itens.setFkCompra(fkCompra);
			itens.setFkProduto(Integer.parseInt(fkProdutoString));
			
			//Salvando os itens
			is.save(itens);
			
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
