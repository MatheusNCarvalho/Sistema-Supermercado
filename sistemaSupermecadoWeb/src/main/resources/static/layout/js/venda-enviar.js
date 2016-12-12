$(function() {
	$( window ).ready(function() {
		 let condicao = $("#verificarCondicao").val();
		 if(condicao=="true"){
			 $('#abrirCaixaModal').modal('show')
		 }		 
		});
});
$(function() {
	 $('#enviarValorInicial').on('click',function(e) {
	     e.preventDefault();
		 let enviar={
				 "saldo" : $("#saldoInicial").val(),
		 }
		 $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/aberturas",
			data : JSON.stringify(enviar),
			dataType : 'json',
			success : function(data) {
				// funcoes para que apos adicionar uma nova option no select fechar o modal
				$('#abrirCaixaModal').modal('hide');
				$('#abrirCaixaModal').hide();
				$('.modal-backdrop').hide();
				$("body").removeClass("modal-open")
			},
			error : function(e) {
			console.log("ERROR: ", e);
			}
		 })
		});
});
$(function() {
    $('#enviar').on('click',function(e) {
        e.preventDefault();
        var pegarTamanhoArray=$('#tamanhoArray').val();

 
        var vals = $('#nomeCliente').val()
	        var cliente = $('#clientes option').filter(function() {
	            return this.value == vals;
	        }).data('clienteok');
	        var clienteId = cliente ? '' + cliente : 'No Match';
	        
      //  var token = $("#token").val()
        var obj = {}
		obj ['d']= clienteId;
		let cot = 101;
        for (count=1; count <= pegarTamanhoArray; count++){
        	if($('.produtoId.'+count).val()==""||$('.produtoId.'+count).val()==null){
      
        	}
      
        	else {
        		obj ['v'+cot] = $("#v_"+count).text()
        		obj ['q'+cot]= $("#q_"+count).val()
        		obj['f'+cot]= $('.produtoId.'+count).val()      		
        	}
     		cot++;
        }
  
        if($("#qtdParcelas").val()==""||$("#qtdParcelas").val()==null){
        	obj['z9']=$("#metodoPagamento").val()+''+$('.aw-box__value.valor').text().replace("R$","")
        }
        else{
        	   obj['z9']=$("#qtdParcelas").val();
        }
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/vendas/salvar",
			data : JSON.stringify(obj),
			dataType : 'json',
			success : function(data) {
				window.location.reload(true);
			},
			error : function(e) {
			console.log("ERROR: ", e);
			}
			})
        console.log(obj)
    });
});