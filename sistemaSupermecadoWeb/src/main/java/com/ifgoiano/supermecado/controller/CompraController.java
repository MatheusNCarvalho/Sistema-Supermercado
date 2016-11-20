package com.ifgoiano.supermecado.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	private Fornecedores fos;
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Compras compras;
	
	
	@Autowired
	private ItemCompras is;

	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("compra/CadastroVenda");
		mv.addObject("compra",new Compra());
		return mv;
		
		
	}
	
	@RequestMapping(value="/salvar",method = RequestMethod.POST)
	public @ResponseBody String salvar(@RequestBody String i){
		System.out.println(i);
		Compra compra = new Compra();
		
		String array[] = new String[61];
		String regex = "\"(,)\"";
		
		int valorCount=1;
		int qtdCount=2;
		int produtoCount=3;
		
		array = i.split(regex);
				System.out.println(array[0]);
				String fornecedorJSON="d";
				String fkfornecedor = array[0].replace(fornecedorJSON, "").replace("{","").replace("\"", "").replace(":", "").replace("}","").replace("/([A-Z])w+(:)/g", "");
				compra.setFkFornecedor(Integer.parseInt(fkfornecedor));
				compra.setDataDaCompra(compra.getDateTime());
				System.out.println(compra.getDataDaCompra());
				compras.save(compra);
				long fkCompra = compra.getIdCompra();
				System.out.println("Id="+fkCompra);
				
				
		for(int o=1;o<array.length;o++){
			String contadorString = Integer.toString(o);
			String valorUnitarioJSON="v"+contadorString;
			String qtdJSON = "q"+contadorString;
			String produtoIdJSON = "f"+contadorString;
			
			String valorUnitarioString = array[valorCount].replace(valorUnitarioJSON, "").replace("{","").replace("\"", "").replace(":", "").replace("}","").replace("/([A-Z])w+(:)/g", "");
			String qtdString = array[qtdCount].replace(qtdJSON, "").replace("{","").replace("\"", "").replace(":", "").replace("}","").replace("/([A-Z])w+(:)/g", "");
			String fkProdutoString = array[produtoCount].replace(produtoIdJSON, "").replace("{","").replace("\"", "").replace(":", "").replace("}","").replace("/([A-Z])w+(:)/g", "");
			System.out.println("valor="+valorUnitarioString);
			System.out.println("qtd="+qtdString);
			System.out.println("ProdutoId"+fkProdutoString);
			
			ItemCompra itens = new ItemCompra();
			
			BigDecimal valorUnitario = new BigDecimal(valorUnitarioString);
			itens.setQtd(Integer.parseInt(qtdString));
			itens.setValorUnitario(valorUnitario);
			itens.setFkCompra(fkCompra);
			itens.setFkProduto(Integer.parseInt(fkProdutoString));
			
			is.save(itens);
			
			
			//System.out.println(itens.getQtd());
			
			//System.out.println(array[o].replace("{","").replace("\"", "").replace(":", "=").replace("}","").replace("/([A-Z])w+(:)/g", ""));
			//array2[0]=array[1].replace("{","").replace("\"", "").replace(":", "=").replace("}","").replace("/([A-Z])w+(:)/g", "")+array[2].replace("{","").replace("\"", "").replace(":", "=").replace("}","").replace("/([A-Z])w+(:)/g", "")+array[3].replace("{","").replace("\"", "").replace(":", "=").replace("}","").replace("/([A-Z])w+(:)/g", "");
	//		System.out.println("Item 1"+array2[0]);
			//compra.setItens(array[]);
			
			valorCount=valorCount+3;
			qtdCount = qtdCount+3;
			produtoCount = produtoCount +3;
			if(valorCount>=array.length){
				break;
			}
		}
		return "ok";
	}
	
}
