function validarProdutos() {
	
	let	formulario = document.forms['formularioProduto'];
	let	formularioOk = false;
	let elementoOk = true;

	let	divCodigoBarras = document.querySelector(".codigoBarras");
	let	codigoBarras = formulario.codigoBarras.value;
	let	divNome = document.querySelector(".nome");
	let	nome = formulario.nome.value;

	let divQtdEstoqueMaximo = document.querySelector(".qtdEstoqueMaximo");
	let qtdEstoqueMaximo = formulario.qtdMaxima.value;
	let divQtdEstoqueMinimo = document.querySelector(".qtdEstoqueMinimo");
	let qtdEstoqueMinimo = formulario.qtdMinimo.value;
	let divMedida = document.querySelector(".medida");
	let medida = formulario.tipoMedida
	let medidaSelecionada = medida.selectedIndex;
	let divQtdMedida = document.querySelector(".qtdMedida");
	let qtdMedida = formulario.qtdMedida.value;
	let divQtdEstoqueMaximo = document.querySelector(".qtdEstoqueMaximo");
	let qtdEstoqueMaximo = formulario.qtdMaxima.value;

	let divCategoria = document.querySelector(".categoria");
	let categoria = formulario.idCategoria;
	let categoriaSelecionada = medida.selectedIndex;
	
	if (codigoBarras == "" || codigoBarras == undefined) {

		
		divCodigoBarras.classList.add("has-error");
		$('.mensagemErroInput')
				.append('<div class="alert alert-danger" >'
							+ '<div th:each="detailedError : ${#fields.detailedErrors()}">'
								+ '<span> Por favor insira o código de barras </span>'
							+ '</div>' +
						'</div>');
		document.getElementById("input-produto-codigo").focus();
		elementoOk = false;

	} else {
		divCodigoBarras.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;	
	}
	

	if (nome == "" || nome == undefined) {

		
		divNome.classList.add("has-error");
		$('.mensagemErroInput')
		.append( '<div class="alert alert-danger" >'+
					'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
						'<span> Por favor insira o nome </span>'+
					'</div>'+
				'</div>');
		document.getElementById("input-produto-nome").focus();
		elementoOk = false;


	} else {
		divNome.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;
	}
	
	
	

	if (medida.selectedIndex == 0 ) {

		
		divMedida.classList.add("has-error");
		$('.mensagemErroInput')
				.append('<div class="alert alert-danger" >'
							+ '<div th:each="detailedError : ${#fields.detailedErrors()}">'
								+ '<span> Por favor insira a medida </span>'
							+ '</div>' +
						'</div>');
		elementoOk = false;

	} else {
		
		divMedida.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;
	}
	
	
	
	if (qtdMedida == "" || qtdMedida == undefined) {

		
		
		divQtdMedida.classList.add("has-error");
		$('.mensagemErroInput')
				.append('<div class="alert alert-danger" >'
							+ '<div th:each="detailedError : ${#fields.detailedErrors()}">'
								+ '<span> Por favor insira a quantidade da medida </span>'
							+ '</div>' +
						'</div>');
		document.getElementById("input-produto-qtdMedida").focus();
		elementoOk = false;
	} else {
		
		divQtdMedida.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;
	}
	
	

	if (qtdEstoqueMaximo == "" || qtdEstoqueMaximo == undefined) {

		
	divQtdEstoqueMaximo.classList.add("has-error");
		$('.mensagemErroInput')
				.append('<div class="alert alert-danger" >'
							+ '<div th:each="detailedError : ${#fields.detailedErrors()}">'
								+ '<span> Por favor insira a quantidade máxima no estoque </span>'
							+ '</div>' +
						'</div>');
		document.getElementById("input-produto-maximo").focus();
		elementoOk = false;
	} else {
		
		divQtdEstoqueMaximo.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;
	}
	
	

	if (qtdEstoqueMaximo == "" || qtdEstoqueMaximo == undefined) {

		
	divQtdEstoqueMaximo.classList.add("has-error");
		$('.mensagemErroInput')
				.append('<div class="alert alert-danger" >'
							+ '<div th:each="detailedError : ${#fields.detailedErrors()}">'
								+ '<span> Por favor insira a quantidade máxima no estoque </span>'
							+ '</div>' +
						'</div>');
		document.getElementById("input-produto-maximo").focus();
		elementoOk = false;
	} else {
		
		divQtdEstoqueMaximo.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;
	}
	

	
	
	if (qtdEstoqueMinimo == "" || qtdEstoqueMinimo == undefined) {

		
		divQtdEstoqueMinimo.classList.add("has-error");
		$('.mensagemErroInput')
				.append('<div class="alert alert-danger" >'
							+ '<div th:each="detailedError : ${#fields.detailedErrors()}">'
								+ '<span> Por favor insira a quantidade mínima no estoque</span>'
							+ '</div>' +
						'</div>');
		document.getElementById("input-produto-minimo").focus();
		elementoOk = false;
	} else {
		
		divQtdEstoqueMinimo.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;
	}
	

	if (categoriaSelecionada == 0 ) {

		
		divCategoria.classList.add("has-error");
		$('.mensagemErroInput')
				.append('<div class="alert alert-danger" >'
							+ '<div th:each="detailedError : ${#fields.detailedErrors()}">'
								+ '<span> Por favor insira a categoria </span>'
							+ '</div>' +
						'</div>');
		elementoOk = false;
	} else {
		
		divCategoria.classList.remove("has-error");
		$('.mensagemErroInput').remove();
		elementoOk = true;
	}
	if(elementoOk){
		formularioOk = true;   
	}else{
		formularioOk = false;
	}
	
	if (formularioOK)
			return true;
	else
		return false;
}

