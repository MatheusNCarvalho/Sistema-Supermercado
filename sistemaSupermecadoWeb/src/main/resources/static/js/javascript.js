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

jQuery(document).ready(function($) {

	$("#search-form").click(function(event) {

		var search = {}
		search["nome"] = $("#nome").val();
		search["descricao"] = $("#descricao").val();
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/categorias",
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data.nome);
				// ao entrar em success inicia uma funcao de criar uma option com o ultimo valor adicionado;
				//$("#focusCategoria").append('<option value='+data.idCategoria+'>'+data.nome+'</option>');
				$.getJSON("/categorias/data/jsonList", function(response){ 
				    $("#focusCategoria option").remove(); 
				    let options = ''; 
				    $("#focusCategoria").empty().append('<option value="0">-Seleccione-</option>');
				    $.each(response, function(index,nome) {
				    	//outra forma de adicionar uma option
				    	// jQuery("<option/>").text(nome.nome).attr("value", nome.id).appendTo("#focusCategoria");
			            options += '<option value="' + nome.id + '">' + nome.nome + '</option>';
			            $("#focusCategoria").append(options);
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
	
	
});
//função que retorna um array de valores e com o array forma um select
/*$('#close').click( function (e) {
	$.getJSON("/categorias/data/jsonList", function(response){ 
	    $("#focusCategoria option").remove(); 
	        let options = ''; 
	        $.each(response, function(index,nome) {
	            options += '<option value="' + nome.id + '">' + nome.nome + '</option>';
	            $("#focusCategoria").html(options);
	        });
	});
});
// outra funcao de adicionar value
 $("#focusCategoria").empty().append('<option value="">-Seleccione-</option>');
 $.each(data, function (idx, item) {
                     jQuery("<option/>").text(item.nome).attr("value", item.id).appendTo("#focusCategoria");
                 })
*/