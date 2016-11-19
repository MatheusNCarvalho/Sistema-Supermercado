var Brewer = Brewer || {};

Brewer.AdicinarProdutos = (function() {
	var count=1;
	function AdicinarProdutos() {
		this.nomeInput = $('#codigoProduto');
		this.pesquisaRapidaBtn = $('#js-adicionar-item-tabela'); 
		this.htmlTabelaPesquisa = $('#template-autocomplete-cerveja').html();
		this.template = Handlebars.compile(this.htmlTabelaPesquisa);
		this.mensagemErro = $('.js-mensagem-erro');
	}
	
	AdicinarProdutos.prototype.iniciar = function() {
		this.pesquisaRapidaBtn.on('click', onPesquisaRapidaClicado.bind(this));

	}

		function onPesquisaRapidaClicado(event) {
		event.preventDefault();

		$.ajax({
			url: "/produtos/adicionar",
			method: 'GET',
			contentType: 'application/json',
			data: {
				codigo: this.nomeInput.val()
			},
			success :function(i,data) {
				$("#produtos").append(
						'<div class="bw-tabela-item">'+
						'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--detalhes">'+
							'<span class="bw-tabela-cerveja-nome">'+i.nome+'</span>'+
							'<input class="produtoId '+count+'" value="'+i.id+'" type="hidden"  />'+
							'<span class="label  label-default" >'+i.codigoBarras+'</span>'+
							'<span class="bw-tabela-cerveja-origem" >'+i.categoria.nome+'</span>'+
						'</div>'+
						'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--valores">'+
						'<div class="bw-tabela-cerveja-valor-pequeno">'+
							'<input id="produtoQtd_'+count+'" name="qtd" type="text" maxlength="3" class="bw-tabela-cerveja-campo-quantidade js-tabela-cerveja-quantidade-item" value="1" data-codigo-cerveja="1">'+
							'<span>x</span>'+
							'<input id="produtoValor_'+count+'" name="valorUnitario "type="text" maxlength="3" class="bw-tabela-cerveja-campo-quantidade js-tabela-cerveja-quantidade-item" value="1" data-codigo-cerveja="1">'+
						'</div>'+
						'<div id="somaId_'+count+'"class="bw-tabela-cerveja-valor-grande">R$0,00</div>'+
					'</div>'+
					'</div>');
				
				
			return count++;	
			},
			error: onErroPesquisa.bind(this)
		});
	}
	
	
	function onErroPesquisa() {
		this.mensagemErro.removeClass('hidden');
	}
	
	return AdicinarProdutos;
	
}());

Brewer.TabelaClientePesquisaRapida = (function() {
	
	function TabelaClientePesquisaRapida(modal) {
		this.modalCliente = modal;
		this.cliente = $('.js-cliente-pesquisa-rapida');
	}
	
	TabelaClientePesquisaRapida.prototype.iniciar = function() {
		this.cliente.on('click', onClienteSelecionado.bind(this));
	}
	
	function onClienteSelecionado(evento) {
		/*this.modalCliente.modal('hide');
		alert(clienteSelecionado.data('codigo'));
		var clienteSelecionado = $(evento.currentTarget);
		$('#nomeCliente').val(clienteSelecionado.data('nome'));
		$('#codigoCliente').val(clienteSelecionado.data('codigo'));*/
	}
	
	return TabelaClientePesquisaRapida;
	
}());

$(function() {
	var AdicinarProdutos = new Brewer.AdicinarProdutos();
	AdicinarProdutos.iniciar();
});

