$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	let button = $(event.relatedTarget);
	let codigoTitulo = button.data('id');
	let descricaoTitulo = button.data('nome');

	
	let modal = $(this);
	let form = modal.find('form');
	let action = button.data('action');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoTitulo);
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');
	
});
$('#modalMovimentoCaixa').on('show.bs.modal',function(event){
	let button = $(event.relatedTarget);
	let nomeModal = button.data('nomemodal');
	$('.modal-title.caixa').html('<strong>'+nomeModal+'</strong>');
	$('#enviarMovimentoCaixa').on('click',function(e) {
	     e.preventDefault();
	     let valor = $('#valorMovimento').val();
	     if(valor<0){
	    	 $('.js-mensagem-cadastro-rapido-estilo').removeClass('hidden');
			 $('.js-mensagem-cadastro-rapido-estilo').html('<span> O valor informado deve ser positivo!</span>');
	     }
	     else{
	    	 let url = button.data('url');
			 let enviar={
					 "valor" : valor,
			 }
		 $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/movimentos/"+url,
			data : JSON.stringify(enviar),
			dataType : 'json',
			success : function(data) {
				location.reload();
			},
			error : function(e) {
			console.log("ERROR: ", e);
			}
		 })
	     }
	    
		});
	

	
});
$('#modalMovimentoCaixa').on('hidden.bs.modal',function(event){
	$('body').css("paddingRight","0px")
});





