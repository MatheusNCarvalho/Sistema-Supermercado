$(document).on('dblclick', '.bw-tabela-item', function() {
    $(this).remove();
    //toda vez que remove uma linha percorre o array de produtos e informa o valor da compra
    let novoValor=0;
    let pegarTamanhoArray=$('#tamanhoArray').val();
	for(let count=1;count<=pegarTamanhoArray;count++){
				let valor = $('#somaId_'+count).text()
				valor = valor.replace("R$","")
				valor = parseFloat(valor)
				if(!valor==""||valor==null){
					novoValor = novoValor+valor
				}
			}

	$('.aw-box__value.valor').replaceWith('<div class="aw-box__value valor">R$'+novoValor+'</div>')	
});
$( document ).ready(function() {
	let valorCaixaInicial=$('#valorDoCaixa').val();
	let valorSaldoCaixa=$('#valorSaldoCaixa').val();
	if (valorSaldoCaixa==""||valorSaldoCaixa==null){
		valorSaldoCaixa=0;
	}
	let total = parseFloat(valorCaixaInicial)+parseFloat(valorSaldoCaixa);
	$('.aw-box__value.valor_caixa').replaceWith('<div class="aw-box__value valor_caixa">R$'+total.toFixed(2)+'</div>');
});

$(document).on('keyup','input[type=text][name=qtd]', function() {
		let id = this.id;
        let pegarTamanhoArray=$('#tamanhoArray').val();
		let qtd = $(this).val();
		let posicao = id.replace("q_","");
		let valorUnitario = $('#v_'+posicao).val();
		let somaValores = valorUnitario * qtd ;
				
		$('#somaId_'+posicao+'').replaceWith(
				'<div id="somaId_'+posicao+'"class="bw-tabela-cerveja-valor-grande">R$'+somaValores+'</div>'
				)
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
});
