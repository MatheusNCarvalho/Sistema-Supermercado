package com.ifgoiano.supermecado.service.exception;



public class FornecedorNomeJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID =1L;
	
	public FornecedorNomeJaCadastradoException(String message){
		super(message);
	}
}
