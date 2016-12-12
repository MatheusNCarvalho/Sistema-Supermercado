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
		let valorUnitario = $('#v_'+posicao).text();
		let somaValores = valorUnitario * qtd ;
				
		$('#somaId_'+posicao+'').replaceWith(
				'<div id="somaId_'+posicao+'"class="bw-tabela-cerveja-valor-grande">R$'+somaValores.toFixed(2)+'</div>'
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
$(document).on('keyup','input[type=text][name=valorUnitario]', function() {
	let id = this.id;
    let pegarTamanhoArray=$('#tamanhoArray').val();
	let qtd = $(this).val();
	let posicao = id.replace("v_","");
	let valorUnitario = $('#q_'+posicao).val();
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
$(document).on('change','#metodoPagamento', function() {
	let metodo = $('#metodoPagamento').val()
	let valor = $('.aw-box__value.valor').text()
	valor = valor.replace("R$","")
	if(metodo==2){
		$('#parcelasId').html('<label for="qtdParcelas">Parcelas</label> <select class="form-control" id="qtdParcelas" name="qtdParcelas" ><option value="0"></option><option value="1x'+valor+'">1x de R$'+valor+'</option><option value="2x'+valor/2+'">2x de R$'+valor/2+'</option><option value="3x'+valor/3+'">3x de R$'+valor/3+'</option><option value="4x'+valor/4+'">4x de R$'+valor/4+'</option><option value="5x'+valor/5+'">5x de R$'+valor/5+'</option><option value="6x'+valor/6+'">6x de R$'+valor/6+'</option></select>')
	}
	if (metodo=='0x'||metodo==0){
		$('#parcelasId').html('')
	}
});
