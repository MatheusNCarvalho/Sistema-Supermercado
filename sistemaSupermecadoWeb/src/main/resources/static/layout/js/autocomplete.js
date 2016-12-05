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
			alert(JSON.stringify(i));
			for(let count=1; count<100; count++)
			{
				alert(JSON.stringify(i));
			$("#produtosAdicionar").append(
					'<div class="bw-tabela-item">'+
					'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--detalhes">'+
						'<span class="bw-tabela-cerveja-nome">'+i.produto.nome+'</span>'+						
						'<span class="label  label-default" >'+i.produto.codigoBarras+'</span>'+
						'<span class="bw-tabela-cerveja-origem" >'+i.categoria.nome+'</span>'+
					'</div>'+
					'<div class="bw-tabela-item__coluna  bw-tabela-item__coluna--valores">'+
					'<div class="bw-tabela-cerveja-valor-pequeno">'+
					'<label>Valor unitário</label>'+
					'<input id="v_'+count+'" name="valorUnitario" type="text" class="bw-tabela-venda-campo-valor" value="0.00">'+
					'<span>x</span>'+
					'<input id="q_'+count+'" name="qtd" type="text" maxlength="3" class="bw-tabela-venda-campo-quantidade" value="1">'+
					'<label>Quantidade</label>'+
					'</div>'+
					'<div id="somaId_'+count+'"class="bw-tabela-cerveja-valor-grande">R$0,00</div>'+
				'</div>'+
				'</div>');
			}
		},
		error: function(e){
			console.log("ERROR: ", e);
		}
	});
	
	
	
	
})