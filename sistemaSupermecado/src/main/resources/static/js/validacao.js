function validaFormCadProduto() {

	let formProduto = document.forms['formProduto'];
	let formProdutoOk = true;

	if (!validaCodigoBarras(formProduto.codigoBarras.value)) {

		formProdutoOk = false;
	}

	if (!validaNome(formProduto.nome.value)) {

		formProdutoOk = false;
	}

	if (!validaValorUnitario(formProduto.valorUnitario.value)) {

		formProdutoOk = false;
	}

	if (!validaQtdEstoque(formProduto.qtdEstoque.value)) {

		formProdutoOk = false;
	}

	if (!validaQtdMinimaEstoque(formProduto.qtdMinimo.value)) {

		formProdutoOk = false;
	}

	if (!validaCategoria()) {

		formProdutoOk = false;
	}

	validarElementoNome();

	if (formProdutoOk)
		return true;
	else
		return false;

	function validarElementoNome() {
		let
		elementoNome = document.forms['formProduto'].nome;
		if (validaNome(elementoNome.value))
			elementoNome.classList.remove("has-error");
		else
			elementoNome.classList.add("has-error");
	}

	function validaCodigoBarras(codigoBarras) {
		if (codigoBarras == "" | codigoBarras == undefined)
			return false;
		else
			return true;
	}

	function validaNome(nome) {
		if (nome == "" | nome == undefined)
			return false;
		else
			return true;
	}

	function validaValorUnitario(valorUnitario) {
		if (valorUnitario == "" | valorUnitario == undefined)
			return false;
		else
			return true;
	}

	function validaQtdEstoque(qtdEstoque) {
		if (qtdEstoque == "" | qtdEstoque == undefined)
			return false;
		else
			return true;
	}

	function validaQtdMinimaEstoque(qtdMinimaEstoque) {
		if (qtdMinimaEstoque == "" | qtdMinimaEstoque == undefined)
			return false;
		else
			return true;
	}

	function validaCategoria() {
		// cadastroProdutoSelect();
		let categoria = document.forms['formProduto'].idCategoria;

		let categoriaIndex = categoria.selectedIndex;
		if (categoriaIndex == 0 | categoriaIndex == undefined)
			return false;
		else
			return true;
	}
}

function validaFormCadCategoria() {

	let formCategoria = document.forms['formCategoria'];
	let formCategoriaOK = true;

	if (!validaNome(formCategoria.nome.value)) {
		console.log('Nome da categoria errado');
		formCategoriaOK = false;
	}
	if (!validaDescricao(formCategoria.descricao.value)) {
		console.log('Descrição errado');
		formCategoriaOK = false;
	}
	if (formCategoriaOK)
		return true;
	else
		return false;

	function validarNome(nome) {
		if (nome == "" | nome == undefined)
			return false;
		else
			return true;
	}
	function validaDescricao(descricao) {
		if (descricao == "" | descricao == undefined)
			return false;
		else
			return true;
	}
}
