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
$(document).ready(function(){
    $('#enviar').click(function(e) {
        e.preventDefault();
        var pegarNome = $('.bw-tabela-cerveja-nome').text();
        var pegarCodigoBarras = $('.label.label-default').text();
        console.log(pegarNome)
        console.log(pegarCodigoBarras)
        var obj = {}
		obj ['d']= $("#codigoCliente").val()
        for (count=0; count <= 20; count++){
        	if($('.produtoId.'+count).val()==""||$('.produtoId.'+count).val()==null){
      
        	}
        	else {
        		obj ['v'+count] =$("#produtoValor_"+count).val()
        		obj ['q'+count]= $("#produtoQtd_"+count).val()
        		obj['f'+count]= $('.produtoId.'+count).val()

        		//obj[count] = '[codigoCliente='+codigoCliente+',valorUnitario='+valorUnitario+',qtd='+qtd+',fkProduto='+fkProduto+']'
      		
        	}
        }

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/compras/salvar",
			data : JSON.stringify(obj),
			dataType : 'json',
			success : function(data) {
				console.log("SUCCESS: ");
			},
			error : function(e) {
			console.log("ERROR: ", e);
			}
			})
        console.log(obj)
    });

});
/*function somarValores(){
	for(let p;p<20;p++){
		let qtdDiv = $('#produtoQtd_'+p+'');
		let valorUnitarioDiv = $('#produtoValor_'+p+'');
		let somaqtd = somaQtd.val();
		let somaValores = qtdDiv * valorUnitarioDiv;
		
		$('#somaId_'+p+'').append(
				'<div id="somaId_'+p+'"class="bw-tabela-cerveja-valor-grande">'+somaValores+'</div>'
				)
		
	}
	
	
}*/