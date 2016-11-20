$(document).on('dblclick', '.bw-tabela-item', function() {
    $(this).remove();
});
$(document).on('keyup','input[type=text][name=qtd]', function() {
		let pegarTamanhoArray =$('#tamanhoArray').val();
		let id = this.id;
		let qtd = $(this).val();
		let valorUnitario = $('input[type=text][name=valorUnitario]');

		let posicao = id.replace("q_","");
		
		
		
		let somaValores = valorUnitario.val() * qtd ;
		
		$('#somaId_'+posicao+'').replaceWith(
				'<div id="somaId_'+posicao+'"class="bw-tabela-cerveja-valor-grande">R$'+somaValores+'</div>'
				)
		
});