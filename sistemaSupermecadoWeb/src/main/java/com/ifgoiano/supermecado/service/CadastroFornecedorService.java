package com.ifgoiano.supermecado.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifgoiano.supermecado.model.Fornecedor;
import com.ifgoiano.supermecado.repository.Fornecedores;
import com.ifgoiano.supermecado.service.exception.FornecedorNomeJaCadastradoException;
import com.ifgoiano.supermecado.service.filtro.FornecedorFiltro;

@Service
public class CadastroFornecedorService {
	
	@Autowired
	private Fornecedores fos;
	
	public void salvar(Fornecedor fo){
		
		
		/*if(fo.getIdFornecedor() != 0 ){
			fos.save(fo);
		}*/
		
		Optional<Fornecedor> fornecedorExistente = fos.findByNomeContaining(fo.getNome());
		//System.out.println(fornecedorExistente.toString());
		
		if(fornecedorExistente.isPresent()){	
				
		
			throw new FornecedorNomeJaCadastradoException(fo.getNome()+" já cadastrado");
		}
		fos.save(fo);
	}
	
	public List<Fornecedor> filtrar(FornecedorFiltro filtro){
		String nome = null;
		nome = filtro.getNome() == null ? "%" : filtro.getNome();
		
		return fos.findByNomeContainingIgnoreCase(nome);
		
		
	}

}
