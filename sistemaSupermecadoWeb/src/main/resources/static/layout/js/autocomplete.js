$(function(){
	
	let idCompra = $('#idCompra').val();
	
	$.ajax({
		url: "/compras/adicionar",
		method: 'GET',
		contentType: 'application/json',
		data: {
			codigo: idCompra
		},
		success :function(i,data){
			console.log(i)
			let array = i.split(",")
			console.log(array)
			let itemNomeCount=0;
			for(i=0;i<array[array.length-1];i++){
				let count=i+1;
				$("#produtosAdicionar").append(
						'<div class="bw-tabela-item">'+
						'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--detalhes">'+
							'<span class="bw-tabela-cerveja-nome">'+array[1+itemNomeCount]+'</span>'+						
							'<span class="label  label-default" >'+array[0+itemNomeCount]+'</span>'+
							'<span class="bw-tabela-cerveja-origem" >'+array[2+itemNomeCount]+'</span>'+
						'</div>'+
						'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--valores">'+
						'<div class="bw-tabela-cerveja-valor-pequeno">'+
						'<label>Valor unitário</label>'+
						'<input id="v_'+count+'" name="valorUnitario" type="text" class="bw-tabela-venda-campo-valor" value="'+array[4+itemNomeCount]+'">'+
						'<span>x</span>'+
						'<input id="q_'+count+'" name="qtd" type="text" maxlength="3" class="bw-tabela-venda-campo-quantidade" value="'+array[3+itemNomeCount]+'">'+
						'<label>Quantidade</label>'+
						'</div>'+
						'<div id="somaId_'+count+'"class="bw-tabela-cerveja-valor-grande">R$0,00</div>'+
					'</div>'+
					'</div>');
			itemNomeCount=itemNomeCount+5;
			}
			  let pegarTamanhoArray=array[array.length-1];
				
				for(let c=1;c<=pegarTamanhoArray;c++){
					let qtd = $('#q_'+c).val();
					let valorUnitario = $('#v_'+c).val();
					let somaValores = valorUnitario * qtd ;
					$('#somaId_'+c+'').replaceWith(
							'<div id="somaId_'+c+'"class="bw-tabela-cerveja-valor-grande">R$'+somaValores+'</div>'
							)
				}
				
				let novoValor=0;
				for(let count=1;count<=pegarTamanhoArray;count++){
							let valor = $('#somaId_'+count).text()
							valor = valor.replace("R$","")
							valor = parseFloat(valor)
							novoValor = novoValor+valor

						}

				$('.aw-box__value.valor').replaceWith('<div class="aw-box__value valor">R$'+novoValor+'</div>')	
				/**/
		},
		error: function(e,data){
			console.log("ERROR: ", e);
		}
	});
	
	
	
	
})
