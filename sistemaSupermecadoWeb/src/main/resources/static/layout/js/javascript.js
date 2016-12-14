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
	     let url = button.data('url');
			 let enviar={
					 "valor" : $('#valorMovimento').val(),
			 }
		 $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/movimentos/"+url,
			data : JSON.stringify(enviar),
			dataType : 'json',
			success : function(data) {
				// funcoes para que apos adicionar uma nova option no select fechar o modal
				$('#modalMovimentoCaixa').modal('hide');
				$('#modalMovimentoCaixa').hide();
				$('.modal-backdrop').hide();
				$("body").removeClass("modal-open")
			},
			error : function(e) {
			console.log("ERROR: ", e);
			}
		 })
		});
	

	
});
$('#modalMovimentoCaixa').on('hidden.bs.modal',function(event){
	$('body').css("paddingRight","0px")
});





