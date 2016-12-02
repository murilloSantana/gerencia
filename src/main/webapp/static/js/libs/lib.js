$(document).ready(function() {
	$('.modal-trigger').leanModal();
	$('select').material_select();
	$('.button-collapse').sideNav();
	// $('.modal-close').modal('close');

	// $(document).on('change', '#cad-maq-tmp', function() {
	//		
	// // $('#cad-maq-tmp').append('<option value="" th:selected="selected"
	// // th:disabled="disabled">Selecione uma Opção</option>')
	// // var valores = JSON.parse($.cookie("valores"));
	// // console.log(valores)
	// // $.each(valores, function(index, value) {
	// // console.log(index)
	// // //$('#cad-min-tmp').append('<option>' + value + '</option>');
	// // });
	// })
});

var habilitarEdicao = function(indice, nome, descricao) {

	var inputNome = $("<td id='td-nome" + indice
			+ "'><input type='text' id='txtnome" + indice + "' value='" + nome
			+ "' /></td>");
	var inputDescricao = $("<td id='td-descricao" + indice
			+ "'><input type='text' id='txtdescricao" + indice + "' value='"
			+ descricao + "' /></td>")
	$('#nome' + indice).replaceWith(inputNome);
	$('#descricao' + indice).replaceWith(inputDescricao);
	$('#btn-editado' + indice).show();
	$('#btn-editar' + indice).hide();

}
// necessario para pegar o CSRF-TOKEN
var geraToken = function() {
	var token = $("input[name='_csrf']").val();
	var header = "X-CSRF-TOKEN";
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
}

var salvarEdicao = function(indice, chaveCategoria) {

	var nome = document.getElementById('txtnome' + indice).value;
	var descricao = document.getElementById('txtdescricao' + indice).value
	var nomeEditado = $("<td id='nome" + indice + "'>" + nome + "</td>");
	var descricaoEditada = $("<td id='descricao" + indice + "'>" + descricao
			+ "</td>");

	geraToken();

	$.ajax({
		url : "editar",
		type : "POST",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify({
			"chaveCategoria" : chaveCategoria,
			"nome" : nome,
			"descricao" : descricao
		}),
		cache : false,
		processData : false,
		success : function(data, textStatus, jQxhr) {

			$('#btn-editado' + indice).hide();
			$('#btn-editar' + indice).show();
			$('#td-nome' + indice).replaceWith(nomeEditado);
			$('#td-descricao' + indice).replaceWith(descricaoEditada);

		},
		error : function(jqXhr, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});
};
var verificaCodigoBarras = function(codigo) {
	if (codigo.length > 12) {
		$
				.ajax({
					url : "http://sandbox.buscape.com/service/findOfferList/754b386948454b375076673d/?barcode="
							+ codigo + "&format=json",
					type : "GET",
					cache : false,
					processData : false,
					success : function(data, textStatus, jQxhr) {
						var produto = data.offer[0].offer;
						var nome = produto.offershortname;
						var descricao = produto.offername;
						$('#cad-nome-prod').val(nome)
						$('#cad-desc-prod').val(descricao)

					},
					error : function(jqXhr, textStatus, errorThrown) {
						console.log(errorThrown)
					}
				})
	}
};

var inserirInformacoesTecnicas = function(nome, precoCompra, categorias,
		precoVenda, descricao) {

	var nomeProduto = $('#cad-nome-prod').val();
	var precoCompra = $('#cad-preco-compra').val();
	var categorias = $('#cad-categoria').val();
	var precoUnitario = $('#cad-preco-venda').val();
	var descricaoProduto = $('#cad-desc-prod').val();

	var produto = {
		"nomeProduto" : nomeProduto,
		"precoCompra" : precoCompra,
		"categorias" : categorias,
		"precoUnitario" : precoUnitario,
		"descricaoProduto" : descricaoProduto
	};
	var urlProduto = "?nomeProduto=" + nomeProduto + "&precoCompra="
			+ precoCompra + "&categorias=" + categorias + "&precoUnitario="
			+ precoUnitario + "&descricaoProduto=" + descricaoProduto;
	geraToken();

	$.get("trataInformacoesTecnicas", produto, function(produto) {
	}, "json");

	window.location.href = "/gerencia/informacoesTecnicas/trataInformacoesTecnicas"
			+ urlProduto;

};

var atualizarListaValorHora = function(numero) {

	$.get("/gerencia/tempo/atualizarListaValorHora",
					{
						"numero" : numero
					},
					function(data) {
						$('#cad-min-tmp').empty();
						$('#cad-mod-tmp').val("")
						$('#cad-pre-tmp').val("")
						$('#cad-min-tmp')
								.append(
										'<option value="" th:selected="selected" th:disabled="disabled">Selecione uma Opção</option>');

						$.each(data, function(index, value) {

							$('#cad-min-tmp').append(
									'<option id="' + value.chaveValorHora
											+ '" >'
											+ value.minuto + '</option>');
						});
						$.cookie('valorSelecionado',JSON.stringify(data));
					})
					
					
};

var preencheDadosValorHora = function(){

	$.each(JSON.parse($.cookie('valorSelecionado')), function(index,value){
		if(value.chaveValorHora == $('#cad-min-tmp').children(":selected").attr("id")){
			$('#cad-mod-tmp').val(value.modelo)
			$('#cad-pre-tmp').val(value.preco)
		}
	});
	
};

var showSubLista = function(id) {
	var btnShow = id == "btn-prod" ? "#conteudo-prod"
			: id == "btn-add" ? "#conteudo-add" : null;
	if ($(btnShow).is(':visible')) {
		$('#' + id).parent().addClass('active');
		$('#' + id).parent().siblings('.collapsible-body').stop(true, false)
				.slideUp({
					duration : 350,
					easing : "easeOutQuart",
					queue : false,
					complete : function() {
						$(this).css('height', '');
					}
				});
	}

	switch (id) {
	case "btn-prod":
		$("#conteudo-prod").show();
		$("#conteudo-default").hide();
		$("#conteudo-add").hide();
		break;
	case "btn-add":
		$("#conteudo-add").show();
		$("#conteudo-prod").hide();
		$("#conteudo-default").hide();
		break;
	}

}

var validadorMonetario = function(valor, id) {

	// removendo caracteres que não sejam números
	var valorFormatado = valor.replace(/\D/g, "");
	// adicionando a vírgula
	if (valorFormatado.length < 3) {
		valorFormatado = valorFormatado.replace(/(\d{2})$/, "0,$1");
	} else {
		var i = 0;
		if (valorFormatado[0] == 0 && valorFormatado.length > 3) {
			valorFormatado = valorFormatado.substring(1, valorFormatado.length);
		}

		valorFormatado = valorFormatado.replace(/(\d{2})$/, ",$1");
	}

	// alterando o html
	document.getElementById(id).value = valorFormatado == null ? valorFormatado
			.contains(',') ? valorFormatado : "" : valorFormatado;
}

var validadorCpf = function(strCPF, id) {
	var cpf;
	var d1 = 0;
	var d2 = 0;
	cpf = strCPF.replace(/\D/g, "");
	document.getElementById(id).value = cpf;
	if (strCPF.length == 11) {
		cpf = strCPF.split("").map(Number);
		cpf.reverse()
		for (var i = 2; i < cpf.length + 1; i++) {
			d1 = i < 11 ? i == 10 ? ((d1 + cpf[i] * i) * 10) % 11 : d1 + cpf[i]
					* i : d1;
			d2 = i == 11 ? ((d2 + cpf[i - 1] * i) * 10) % 11 : d2 + cpf[i - 1]
					* i;
		}
		var digito1 = cpf[1] == d1 ? true : d1 == 10 ? true : d1 == 11 ? true
				: false;
		var digito2 = digito1 ? cpf[0] == d2 ? true : d2 == 10 ? true
				: d2 == 11 ? true : false : false;

		console.log(digito1)
		if (digito1 & digito2)
			console.log("cpf Valido");
		else
			console.log("cpf Invalido");

	}

}
