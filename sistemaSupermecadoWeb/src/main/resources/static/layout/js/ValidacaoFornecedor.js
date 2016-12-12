function validarFornecedor() {
	let	formulario = document.forms['formularioFornecedor'];
	let	formularioOk = true;
	let elementoOk = true;
	
	let	divNome = document.querySelector(".nome");
	let	nome = formulario.nome.value;
	
	let	divCnpj = document.querySelector(".cnpj");
	let	cnpj = formulario.cnpj.value;
	
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

		elementoOk = false;
		divNome.classList.add("has-error");
		$('.mensagemErroInput')
		.append( '<div class="alert alert-danger" >'+
		'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
			'<span> Por favor insira o nome </span>'+
		'</div>'+
		
  '</div>');
		document.getElementById("nome").focus();



	} else {
		elementoOk = true;
		divNome.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (cnpj == "" || cnpj == undefined) {

		elementoOk = false;
		divCnpj.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o CNPJ</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divCnpj.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (telefone == "" || telefone == undefined) {

		elementoOk = false;
		divTelefone.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o telefone</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divTelefone.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (logradouro == "" || logradouro == undefined) {

		elementoOk = false;
		divLogradouro.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o logradouro</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divLogradouro.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (bairro == "" || bairro == undefined) {

		elementoOk = false;
		divBairro.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o bairro</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divBairro.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (cidade == "" || cidade == undefined) {

		elementoOk = false;
		divCidade.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira a cidade</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divCidade.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (estado == "" || estado == undefined) {

		elementoOk = false;
		divEstado.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o estado</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divEstado.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (pais == "" || pais == undefined) {

		elementoOk = false;
		divPais.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o país</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divPais.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if (cep == "" || cep == undefined) {

		elementoOk = false;
		divCep.classList.add("has-error");
		$('.mensagemErroInput')
		.append('<div class="alert alert-danger" >'+
				'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
					'<span> Por favor insira o cep</span>'+
				'</div>'+				
		  '</div>');


	} else {
		elementoOk = true;
		divCep.classList.remove("has-error");
		$('.mensagemErroInput').remove();
	}
	
	if(elementoOk)
		formularioOk = true;
	else
		formularioOk = false;
	
	if (formularioOK)
		return true;
	else
		return false;
}
