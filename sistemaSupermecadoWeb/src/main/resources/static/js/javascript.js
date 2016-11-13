/*$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
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

jQuery(document).ready(function($) {

	$("#search-form").click(function(event) {

		var search = {}
		search["nome"] = $("#nome").val();
		search["descricao"] = $("#descricao").val();
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : $('.form').attr('action'),
			data : JSON.stringify(search),
			dataType : 'json',
			success : function(data) {
				console.log("SUCCESS: ", data.nome);
				// ao entrar em success inicia uma funcao de criar uma option com o ultimo valor adicionado;
				$.getJSON("/categorias/data/jsonList", function(response){ 
				    $("#focusCategoria option").remove(); 
				    $("#focusCategoria").empty().append('<option value="0">-Seleccione-</option>');
				    $.each(response, function(index,nome) {
				    	jQuery("<option/>").text(nome.nome).attr("value", nome.id).appendTo("#focusCategoria");
			            });
				});
		
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			}
		});
		// Prevent the form from submitting via the browser.
		event.preventDefault();
	});
	
	
});*/