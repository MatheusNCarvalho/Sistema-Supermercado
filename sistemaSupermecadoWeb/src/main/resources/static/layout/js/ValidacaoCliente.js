function validarCliente() {
	let	formulario = document.forms['formularioCliente'];
	let	formularioOk = true;
	let elementoOk = true;
	
	let	divNome = document.querySelector(".nome");
	let	nome = formulario.nome.value;
	
	let	divCpf = document.querySelector(".cpf");
	let	cpf = formulario.cpf.value;
	
	let	telefone = formulario.telefone.value;
	let divTelefone = document.querySelector(".telefone");
	
	let	logradouro = formulario.logradouro.value;
	let divLogradouro = document.querySelector(".logradouro");
	
	let	bairro = formulario.bairro.value;
	let divBairro = document.querySelector(".bairro");
	
	let	cidade = formulario.cidade.value;
	let divCidade = document.querySelector(".cidade");
	
	let	estado = formulario.estado.value;
	let divEstado = document.querySelector(".estado");
	
	let	pais = formulario.pais.value;
	let divPais = document.querySelector(".pais");
	
	let	cep = formulario.cep.value;
	let divCep = document.querySelector(".cep");

	if (nome == "" || nome == undefined) {

		elementoOK = false;
		divNome.classList.add("has-error");
		$('.mensagemErroInput')
		.append( '<div class="alert alert-danger" >'+
		'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
			'<span> Por favor insira o nome </span>'+
		'</div>'+
		
  '</div>');
		document.getElementById("nome").focus();



	} else {
		elementoOK = true;
		divNome.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (cpf == "" || cpf == undefined) {

		elementoOK = false;
		divCpf.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o CNPJ</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementooOK = true;
		divCpf.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (telefone == "" || telefone == undefined) {

		elementoOK = false;
		divTelefone.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o telefone</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOK = true;
		divTelefone.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (logradouro == "" || logradouro == undefined) {

		elementoOK = false;
		divLogradouro.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o logradouro</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOK = true;
		divLogradouro.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (bairro == "" || bairro == undefined) {

		elementoOK = false;
		divBairro.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o bairro</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOK = true;
		divBairro.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (cidade == "" || cidade == undefined) {

		elementoOK = false;
		divCidade.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira a cidade</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOK = true;
		divCidade.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (estado == "" || estado == undefined) {

		elementoOK = false;
		divEstado.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o estado</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOK = true;
		divEstado.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (pais == "" || pais == undefined) {

		elementoOK = false;
		divPais.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o país</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOK = true;
		divPais.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (cep == "" || cep == undefined) {

		elementoOK = false;
		divCep.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o cep</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOK = true;
		divCep.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	if(elementoOK){
		formularioOk = true;
	}else{
		formularioOK = false;
	}

	if (formularioOK)
		return true;
	else
		return false;
}
