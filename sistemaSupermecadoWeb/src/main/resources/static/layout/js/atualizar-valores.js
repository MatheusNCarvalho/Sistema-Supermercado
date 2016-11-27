$(document).on('dblclick', '.bw-tabela-item', function() {
    $(this).remove();
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