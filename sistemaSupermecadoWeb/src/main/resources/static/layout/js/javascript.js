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
	let nomeModal = button.data('id');
	alert(nomeModal)
	
	let modal=$(this);
	let form = modal.find('form');
	let action = button.data('action');
	if(!action.endsWith('/')){
		action+='/';
	}

	$('.modal-title').text("asdsadasdasdsda").fadeIn()
	
});





