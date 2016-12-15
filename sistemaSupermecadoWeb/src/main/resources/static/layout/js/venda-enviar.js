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
	     let valor =$("#saldoInicial").val();
	     if (valor<0){
	    	 $('.js-mensagem-cadastro-rapido-estilo').removeClass('hidden');
			 $('.js-mensagem-cadastro-rapido-estilo').html('<span> O valor informado deve ser positivo!</span>');
	     }
	     else{
	    	 let enviar={
					 "saldo" : valor,
			 }
			 $.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/aberturas",
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
$(function() {
	 $('#enviarValorFechamento').on('click',function(e) {
	     e.preventDefault();
	     let valorFinal=parseFloat($("#saldoFinal").val()).toFixed(2);
	     let valorSaldoCaixa=parseFloat($("#valorSaldoCaixa").val()).toFixed(2);
	     let valorCaixa=parseFloat($('#valorDoCaixa').val()).toFixed(2);
	     if(valorSaldoCaixa==""||valorSaldoCaixa==null){
	    	 valorSaldoCaixa=0;
	     }
	     console.log(valorFinal);
	     console.log(valorCaixa);
	     let valores=parseFloat(valorCaixa)+parseFloat(valorSaldoCaixa);
	     if (valores!=valorFinal){
				$('.js-mensagem-cadastro-rapido-estilo').removeClass('hidden');
				$('.js-mensagem-cadastro-rapido-estilo').html('<span> Valor Incorreto o valor deve ser '+valores+'R$</span>')
	     }
	     else{
	    	 let enviar={
					 "saldoFinal" : valorFinal,
			 }
			 $.ajax({
				type : "POST",
				contentType : "application/json",
				url : "/fechamentos",
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