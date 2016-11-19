var SysteMark = SysteMark || {};

SysteMark.PesquisaRapidaCliente = (function() {
	
	function PesquisaRapidaCliente() {
		this.pesquisaRapidaClientesModal = $('#pesquisaRapidaProdutos');
		this.nomeInput = $('#codigoProdutoModal');
		this.pesquisaRapidaBtn = $('.js-pesquisa-rapida-produtos-btn'); 
		this.containerTabelaPesquisa = $('#containerTabelaPesquisaRapidaProdutos');
		this.htmlTabelaPesquisa = $('#tabela-pesquisa-rapida-produto').html();
		this.template = Handlebars.compile(this.htmlTabelaPesquisa);
		this.mensagemErro = $('.js-mensagem-erro');
	}
	
	PesquisaRapidaCliente.prototype.iniciar = function() {
		this.pesquisaRapidaBtn.on('click', onPesquisaRapidaClicado.bind(this));
		this.pesquisaRapidaClientesModal.on('shown.bs.modal', onModalShow.bind(this));

	}
	
	function onModalShow() {
		this.nomeInput.focus();
	}
	
	function onPesquisaRapidaClicado(event) {
		event.preventDefault();
		
		$.ajax({
			url: this.pesquisaRapidaClientesModal.find('form').attr('action'),
			method: 'GET',
			contentType: 'application/json',
			data: {
				codigo: this.nomeInput.val()
			}, 
			success: onPesquisaConcluida.bind(this),
			error: onErroPesquisa.bind(this)
		});
	}
	
	function onPesquisaConcluida(resultado) {
		this.mensagemErro.addClass('hidden');
		
		var html = this.template(resultado);
		this.containerTabelaPesquisa.html(html);
		
		var tabelaClientePesquisaRapida = new SysteMark.TabelaClientePesquisaRapida(this.pesquisaRapidaClientesModal);
		tabelaClientePesquisaRapida.iniciar();
	} 
	
	function onErroPesquisa() {
		this.mensagemErro.removeClass('hidden');
	}
	
	return PesquisaRapidaCliente;
	
}());

SysteMark.TabelaClientePesquisaRapida = (function() {
	
	function TabelaClientePesquisaRapida(modal) {
		this.modalCliente = modal;
		this.cliente = $('.js-cliente-pesquisa-rapida');
	}
	
	TabelaClientePesquisaRapida.prototype.iniciar = function() {
		this.cliente.on('click', onClienteSelecionado.bind(this));
	}
	
	function onClienteSelecionado(evento) {
		this.modalCliente.modal('hide');
		
		var clienteSelecionado = $(evento.currentTarget);
		$('#nomeProduto').val(clienteSelecionado.data('nome'));
		$('#codigoProduto').val(clienteSelecionado.data('codigo'));
	}
	
	return TabelaClientePesquisaRapida;
	
}());

$(function() {
	var pesquisaRapidaCliente = new SysteMark.PesquisaRapidaCliente();
	pesquisaRapidaCliente.iniciar();
});