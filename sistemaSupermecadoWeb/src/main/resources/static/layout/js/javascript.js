$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	let button = $(event.relatedTarget);
	let codigoTitulo = button.data('id');
	let descricaoTitulo = button.data('nome');

	
	let modal = $(this);
	let form = modal.find('form');
	let action = button.data('action');
	if (!action.endsWith('/')) {
		action += '/';
	};
	form.attr('action', action + codigoTitulo);
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');
	
});
$(function() {
    $('#enviar').on('click',function(e) {
        e.preventDefault();
        var pegarTamanhoArray=$('#tamanhoArray').val();

 
        var vals = $('#nomeFornecedor').val()
	        var fornecedor = $('#fornecedores option').filter(function() {
	            return this.value == vals;
	        }).data('fornecedor');
	        var fornecedorId = fornecedor ? '' + fornecedor : 'No Match';
	        
      //  var token = $("#token").val()
        var obj = {}
		obj ['d']= fornecedorId;
		let cot = 101;
        for (count=1; count <= pegarTamanhoArray; count++){
        	if($('.produtoId.'+count).val()==""||$('.produtoId.'+count).val()==null){
      
        	}
      
        	else {
        		obj ['v'+cot] =$("#v_"+count).val()
        		obj ['q'+cot]= $("#q_"+count).val()
        		obj['f'+cot]= $('.produtoId.'+count).val()      		
        	}
     		cot++;
        }
        
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/compras/salvar",
			data : JSON.stringify(obj),
			dataType : 'json',
			success : function(data) {
				console.log("SUCCESS: ",data);
			},
			error : function(e) {
			console.log("ERROR: ", e);
			}
			})
        console.log(obj)
    });
});