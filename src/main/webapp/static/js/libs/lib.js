$(document).ready(function() {
	$('.modal-trigger').leanModal();
	$('select').material_select();
	$('.button-collapse').sideNav();
	// $('.modal-close').modal('close');


	
	$("#cad-nome-prod-temp0").easyAutocomplete(getProdutos(0));
	$("#cad-nome-prod-temp1").easyAutocomplete(getProdutos(1));
	$("#cad-nome-prod-temp3").easyAutocomplete(getProdutos(2));
	$("#cad-nome-prod-temp4").easyAutocomplete(getProdutos(3));
	$("#cad-nome-prod-temp5").easyAutocomplete(getProdutos(4));
	$("#cad-nome-prod-temp6").easyAutocomplete(getProdutos(5));
	$("#cad-nome-prod-temp7").easyAutocomplete(getProdutos(6));
	$("#cad-nome-prod-temp8").easyAutocomplete(getProdutos(7));
	$("#cad-nome-prod-temp9").easyAutocomplete(getProdutos(8));
	$("#cad-nome-prod-temp10").easyAutocomplete(getProdutos(9));
	$("#cad-nome-prod-temp11").easyAutocomplete(getProdutos(10));
	$("#cad-nome-prod-temp12").easyAutocomplete(getProdutos(11));
	$("#cad-nome-prod-temp13").easyAutocomplete(getProdutos(12));


});

var preencheCamposCodigo = function(codigo){
	var produto;
	if(codigo.length > 12){
		var retorno
		$.ajax({
		    url:    "/gerencia/tempo/carregarProdutos",
		    type:   "get",
		    dataType:"json",
		    async: false,

		    success: function( data ){
		        produto = data.find(function(value){
		        	return value.codigoBarras == codigo;
		        });        
		    }
		});
		$("#cad-nome-prod-temp").val(produto.nomeProduto);
		$("#label-nome-prod-temp").addClass('active');

		$("#cad-pre-prod-temp").val(produto.precoUnitario);
		$("#label-pre-prod-temp").addClass('active');

		$("#cad-chave-prod-temp").val(produto.chaveProduto);
	 }
};

var getProdutos = function(id){
	var retorno;

	$.ajax({
	    url:    "/gerencia/tempo/carregarProdutos",
	    type:   "get",
	    dataType:"json",
	    async: false,

	    success: function( data ){
	        retorno = data;        
			$.cookie('listaProdutos',JSON.stringify(retorno));
	    }
		
	});

	var produtos = {
			data:retorno,
			getValue: "nomeProduto",
			list: {
				match: {
					enabled: true
				},
				onSelectItemEvent:function(){
					var codigoBarras = $('#cad-nome-prod-temp'+id).getSelectedItemData().codigoBarras;
					var precoUnitario = $('#cad-nome-prod-temp'+id).getSelectedItemData().precoUnitario;
					var chaveProduto = $('#cad-nome-prod-temp'+id).getSelectedItemData().chaveProduto;
					$("#cad-cod-prod-temp"+id).val(codigoBarras).trigger("change");
					$("#cad-pre-prod-temp"+id).val(precoUnitario).trigger("change");
					$("#cad-chave-prod-temp"+id).val(chaveProduto).trigger("change");
				}
			},
			adjustWidth: false
	}
//	var arrayNomesFormatado='{"nome":"murillo"}';
//	var arrayNomesFormatado='{';
//
//	retorno.forEach(function(obj){
//		arrayNomesFormatado+='"'+obj.nomeProduto+'"'+':null,';
		


//	})
//	arrayNomesFormatado+="nome:null}";
//	arrayNomesFormatado = arrayNomesFormatado.slice(0,arrayNomesFormatado.lastIndexOf(","))
//	arrayNomesFormatado+='}';
//	console.log(JSON.parse(arrayNomesFormatado))
	
//	return JSON.parse(arrayNomesFormatado);
	return produtos;
}
//necessario para pegar o CSRF-TOKEN
var geraToken = function() {
	var token = $("input[name='_csrf']").val();
	var header = "X-CSRF-TOKEN";
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
};

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

};


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

var inserirInformacoesTecnicas = function(codigoBarras,nome, precoCompra, categorias,
		precoVenda, descricao) {
	
	var codigoBarras = $('#cad-codigo-barras-prod').val();
	var nomeProduto = $('#cad-nome-prod').val();
	var precoCompra = $('#cad-preco-compra').val();
	var categorias = $('#cad-categoria').val();
	var precoUnitario = $('#cad-preco-venda').val();
	var descricaoProduto = $('#cad-desc-prod').val();

	var produto = {
		"codigoBarras":codigoBarras,	
		"nomeProduto" : nomeProduto,
		"precoCompra" : precoCompra,
		"categorias" : categorias,
		"precoUnitario" : precoUnitario,
		"descricaoProduto" : descricaoProduto
	};
	var urlProduto = "?codigoBarras="+ codigoBarras +"&nomeProduto=" + nomeProduto + "&precoCompra="
			+ precoCompra + "&categorias=" + categorias + "&precoUnitario="
			+ precoUnitario + "&descricaoProduto=" + descricaoProduto;
	geraToken();

	$.get("trataInformacoesTecnicas", produto, function(produto) {
	}, "json");

	window.location.href = "/gerencia/informacoesTecnicas/trataInformacoesTecnicas"
			+ urlProduto;

};

var atualizarListaValorHora = function(chaveMaquina,isLista) {
	var extensaoId = isLista ? "-list" : "";

	
	
	$.get("/gerencia/tempo/atualizarListaValorHora",
					{
						"chaveMaquina" : chaveMaquina
					},
					function(data) {
						$('#cad-min-tmp'+extensaoId).empty();
						$('#cad-mod-tmp'+extensaoId).val("")
						$('#cad-pre-tmp'+extensaoId).val("")
						$('#cad-min-tmp'+extensaoId)
								.append(
										'<option value="" th:selected="selected" th:disabled="disabled">Selecione uma Opção</option>');

						
						$.each(data, function(index, value) {
							$('#cad-min-tmp'+extensaoId).append(
									'<option id="' + value.chaveValorHora
											+ '" >'
											+ value.minuto + '</option>');
						});
						$.cookie('valorSelecionado',JSON.stringify(data));
					})		
					
};


var preencheDadosValorHora = function(isLista){
	var extensaoId = isLista ? "-list" : "";

	$.each(JSON.parse($.cookie('valorSelecionado')), function(index,value){
		if(value.chaveValorHora == $('#cad-min-tmp'+extensaoId).children(":selected").attr("id")){
			$('#cad-mod-tmp'+extensaoId).val(value.modelo)
			$('#cad-pre-tmp'+extensaoId).val(value.preco)
		}
	});
	
};

var showSubLista = function(id,indice) {
	id = id+indice;
	var btnShow = id == "btn-prod"+indice ? "#conteudo-prod"+indice
			: id == "btn-add-alarm"+indice ? "#conteudo-add"+indice : id == "btn-off-alarm"+indice ? "#conteudo-off"+indice : null;
	if ($(btnShow).is(':visible')) {
		$('#' + id ).parent().addClass('active');
		$('#' + id ).parent().siblings('.collapsible-body').stop(true, false)
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
	case "btn-prod"+indice:
		$("#conteudo-prod"+indice).show();
		$("#conteudo-default"+indice).hide();
		$("#conteudo-add"+indice).hide();
		$("#conteudo-off"+indice).hide();
		break;
	case "btn-add-alarm"+indice:
		$("#conteudo-add"+indice).show();
		$("#conteudo-prod"+indice).hide();
		$("#conteudo-default"+indice).hide();
		$("#conteudo-off"+indice).hide();
		break;
	case "btn-off-alarm"+indice:
		$("#conteudo-off"+indice).show();
		$("#conteudo-prod"+indice).hide();
		$("#conteudo-default"+indice).hide();
		$("#conteudo-add"+indice).hide();
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
		cpf.reverse();
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

		var numeros = ['0','1','2','3','4','5','6','7','8','9'];
		var numerosIguais = [] ;
		
		for (var i = 0; i < numeros.length; i++) {
			cpf.forEach(function(value){
				if(value == numeros[i])
					numerosIguais.push(value);
			});
			
			if(numerosIguais.length == 11){
				digito1 = false;
			}else{
				numerosIguais = [];
			}
		}
		
		if (digito1 & digito2)
			console.log("cpf Valido");
		else
			console.log("cpf Invalido");

	}

}
