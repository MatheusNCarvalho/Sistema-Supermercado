$(function() {
    $('#enviar').on('click',function(e) {
        e.preventDefault(); 
        
        var pegarTamanhoArray=$('#tamanhoArray').val();
        let divCarinho = document.querySelector(".carrinho");
        let divNomeProduto = document.querySelector(".produto");
        let valoresCompra= $('.bw-tabela-venda-campo-valor').val()
        alert(valoresCompra)
        if( valoresCompra ==""||valoresCompra==null){
        	//$('.tab-content').html('Tem certeza que deseja excluir o título <strong>');
        	divCarinho.classList.add("has-error");
        	divNomeProduto.classList.add("has-error");
        	
        	/*$('.vali').append( '<div class="alert alert-danger" >'+
			'<div th:each="detailedError : ${#fields.detailedErrors()}">'+
				'<span> Por favor Adicione um Produto</span>'+
			'</div>'+
			
        	'</div>');*/
        }
        else
        {       	 
        	divNomeProduto.classList.remove("has-error");
        	
        			var vals = $('#nomeFornecedor').val()
			        var fornecedor = $('#fornecedores option').filter(function() {
			            return this.value == vals;
			        }).data('fornecedor');
        			
			        var fornecedorId = fornecedor ? '' + fornecedor : 'Match';;
			        
			        
			        if(fornecedorId == 'Match' ){
			        	
			        	divNomeProduto.classList.add("has-error");
			        }
			        else{
			        	
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
								window.location.reload(true);
								console.log("SUCCESS: ",data);
							},
							error : function(e) {
							console.log("ERROR: ", e);
							}
							})
				        console.log(obj)
		        	
			        	
			        }
			        
		  
        }     
       
 
 
    });
});