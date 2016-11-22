package br.com.gerencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gerencia.constants.StaticCaminho;
import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.Produto;
import br.com.gerencia.service.CategoriaService;
import br.com.gerencia.service.ProdutoService;
import br.com.gerencia.util.Conversor;

@Controller
public class CtrlProduto {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private Conversor conversor;
	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = { "/produto" }, method = RequestMethod.GET)
	public String produtoPage(Model model) {
		model.addAttribute("produtos", produtoService.listarProdutos());
		return StaticCaminho.strCaminhoControleEstoque + StaticCaminho.strProduto + "produtos";
	}
	
	@RequestMapping(value = {"/trataInformacoesTecnicas"}, method = RequestMethod.GET)
	public  String informacoesTecnicasPage(@RequestParam (value="nomeProduto") String teste){
		System.out.println(teste);
		return StaticCaminho.strCaminhoControleEstoque + StaticCaminho.strProduto + "informacoes-tecnicas";
	}
	@RequestMapping(value = {"/salvarInformacoesTecnicas"}, method = RequestMethod.GET)
	public String salvarInformacoesTecnicas(RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("teste", "teste do mu");
		return "redirect:cadastroProduto";
	}
	
	@RequestMapping(value = { "/cadastroProduto" }, method = RequestMethod.GET)
	public String cadastroProduto(Model model, @ModelAttribute (value = "produtotemp") String teste) {
		try {
			model.addAttribute("produto", new Produto());
			List<Categoria> categorias = categoriaService.listarCategorias();
			model.addAttribute("allCategorias", categorias);
		} catch (Exception e) {
		}
		return StaticCaminho.strCaminhoControleEstoque + StaticCaminho.strProduto + "cadastro-produto";
	}

	@RequestMapping(value = { "/salvarProduto" }, method = RequestMethod.POST)
	public String salvarProduto(@ModelAttribute(value = "produto") Produto produto) {
		produto.setPrecoCompra(conversor.StringToDouble(produto.getPrecoCompraNoFormatado()));
		produto.setPrecoUnitario(conversor.StringToDouble(produto.getPrecoUnitarioNoFormatado()));
		//System.out.println(produto.getCategorias().size());
		// produtoService.salvarProduto(produto);
		return "redirect:cadastroProduto";
	}
}
