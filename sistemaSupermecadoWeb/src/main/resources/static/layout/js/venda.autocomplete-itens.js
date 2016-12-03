
let count=1;
$('#js-adicionar-item-tabela').on('click',function(e) {
		 let val = $('#nomeProduto').val();
	        let id = $('#produtos option').filter(function() {
	            return this.value == val;
	        }).data('id');
	        let msg = id ? '' + id : 'No Match';
	     
		event.preventDefault();

		$.ajax({
			url: "/produtos/adicionar",
			method: 'GET',
			contentType: 'application/json',
			data: {
				codigo: msg
			},
			success :function(i,data) {
				// variavel para saber se item for igual
				let ok=false;
				// for que percorre todos itens e verifica  cada item se e igual ao adicionado
				for(let contador=1;contador<=count;contador++){
					let valor = $('.produtoId.'+contador).val();
					if(valor==i.id)
					{
					let itemIgualAdicionar=$('#q_'+contador+'').val()
					$('#q_'+contador+'').val(parseFloat(itemIgualAdicionar)+1)
					$('#somaId_'+contador).html('R$ '+$('#v_'+contador).text()*$('#q_'+contador).val())
					let pegarTamanhoArray=$('#tamanhoArray').val();
					let novoValor=0;
					for(let count=1;count<=pegarTamanhoArray;count++){
								let valor = $('#somaId_'+count).text()
								valor = valor.replace("R$","")
								valor = parseFloat(valor)
								if(!valor==""||valor==null){
									novoValor = novoValor+valor
								}
							}

					$('.aw-box__value.valor').replaceWith('<div class="aw-box__value valor">R$'+novoValor+'</div>')	
					

					return ok=true;
					}

					
				}
				if(ok==false){
				$("#produtosAdicionar").append(
						'<div class="bw-tabela-item">'+
						'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--detalhes">'+
							'<span class="bw-tabela-cerveja-nome">'+i.nome+'</span>'+
							'<input class="produtoId '+count+'" value="'+i.id+'" type="hidden"  />'+
							'<span class="label  label-default" >'+i.codigoBarras+'</span>'+
							'<span class="bw-tabela-cerveja-origem" >'+i.categoria.nome+'</span>'+
						'</div>'+
						'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--valores">'+
						'<div class="bw-tabela-cerveja-valor-pequeno">'+
						'<span id="v_'+count+'" name="valorUnitario" type="text" class="bw-tabela-venda-campo-valor-venda" value="'+i.valorUnitario+'">'+i.valorUnitario.toFixed(2)+'</span>'+
						'<span>x</span>'+
						'<input id="q_'+count+'" name="qtd" type="text" maxlength="3" class="bw-tabela-venda-campo-quantidade" value="1">'+
						'</div>'+
						'<div id="somaId_'+count+'"class="bw-tabela-cerveja-valor-grande">R$0,00</div>'+
					'</div>'+
					'</div>');
				$('#tamanhoArray').val(count);
				
			return count++;
				}
			},
			error: function(e){
				console.log("ERROR: ", e);
			}
		});
 });
