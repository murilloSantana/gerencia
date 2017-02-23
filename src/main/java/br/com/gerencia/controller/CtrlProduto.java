package br.com.gerencia.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gerencia.constants.StaticCaminho;
import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.InformacoesTecnicas;
import br.com.gerencia.model.Produto;
import br.com.gerencia.service.CategoriaService;
import br.com.gerencia.service.ProdutoService;
import br.com.gerencia.util.FormatadorUtil;

@Controller
@RequestMapping(value={"/informacoesTecnicas","/produto"})
public class CtrlProduto {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private FormatadorUtil formatador;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private Produto produto;


	@RequestMapping(value = { "/lista" }, method = RequestMethod.GET)
	public String produtoPage(Model model) {
		model.addAttribute("produtos", produtoService.listarProdutos());
		return StaticCaminho.strCaminhoControleEstoque + StaticCaminho.strProduto + "produtos";
	}

	@RequestMapping(value = { "/trataInformacoesTecnicas" }, method = RequestMethod.GET)
	public ModelAndView informacoesTecnicasPage(ModelAndView model,
			@RequestParam(value = "nomeProduto") String nomeProduto,
			@RequestParam(value = "precoCompra") String precoCompra,
			@RequestParam(value = "categorias") Long[] categorias,
			@RequestParam(value = "precoUnitario") String precoUnitario,
			@RequestParam(value = "descricaoProduto") String descricaoProduto, HttpServletRequest request) {

		model.addObject("informacoesTecnicas", new InformacoesTecnicas());
		produto.setNomeProduto(nomeProduto);
		produto.setPrecoCompra(formatador.StringToDouble(precoCompra));		
		produto.setCategoriaId(Arrays.asList(categorias));
		produto.setPrecoUnitario(formatador.StringToDouble(precoUnitario));
		produto.setDescricaoProduto(descricaoProduto);
		produto.setPrecoCompraNoFormatado(formatador.formatarVirgula(produto.getPrecoCompra().toString()));
		produto.setPrecoUnitarioNoFormatado(formatador.formatarVirgula(produto.getPrecoUnitario().toString()));
		
		model.setViewName(StaticCaminho.strCaminhoControleEstoque + StaticCaminho.strProduto + "informacoes-tecnicas");

		request.getSession().setAttribute("produto", produto);
		return model;
	}

	@RequestMapping(value = { "/salvarInfo" }, method = RequestMethod.POST)
	public ModelAndView salvarInformacoesTecnicas(
			@ModelAttribute("informacoesTecnicas") InformacoesTecnicas informacoesTecnicas, ModelAndView model,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		Produto produto = (Produto) request.getSession().getAttribute("produto");
		model.setViewName("redirect:/produto/cadastro");
		
		redirectAttributes.addFlashAttribute(produto);
		redirectAttributes.addFlashAttribute("info", informacoesTecnicas);

		return model;
	}

	@RequestMapping(value = { "/cadastro" }, method = RequestMethod.GET)
	public String cadastroProduto(HttpServletRequest request, Model model, @ModelAttribute("produto") Produto produto,
			@ModelAttribute("info") InformacoesTecnicas informacoesTecnicas) {
		try {

//			model.addAttribute("produto", produto == null ? new Produto() : produto);

			if (informacoesTecnicas != null) {
				request.getSession().setAttribute("info", informacoesTecnicas);
			}

			List<Categoria> categorias = categoriaService.listarCategorias();
			model.addAttribute("allCategorias", categorias);

		} catch (Exception e) {
		}
		return StaticCaminho.strCaminhoControleEstoque + StaticCaminho.strProduto + "cadastro-produto";
	}

	@RequestMapping(value = { "/salvar" }, method = RequestMethod.POST)
	public String salvarProduto(@ModelAttribute(value = "produto") Produto produtoDTO, HttpServletRequest request){
//		InformacoesTecnicas informacoesTecnicas = (InformacoesTecnicas) request.getSession().getAttribute("info");

		produtoDTO.setPrecoCompra(formatador.StringToDouble(produtoDTO.getPrecoCompraNoFormatado()));
		produtoDTO.setPrecoUnitario(formatador.StringToDouble(produtoDTO.getPrecoUnitarioNoFormatado()));

		//		produtoDTO.setInfoTecnicas(informacoesTecnicas);
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
//		List<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();
//		produtos.add(produtoDTO);
		for (Long categoriaId : produtoDTO.getCategoriaId()) {

//			CategoriaDTO categoriaDTO = MapperDTO.INSTANCE.categoriaToCategoriaDTO(categoriaService.pesquisarCategoriaPorChave(categoriaId));
//			categoriaDTO.setProdutos(produtoDTO);
			Categoria categoriaDTO = categoriaService.pesquisarCategoriaPorChave(categoriaId);

			categoriaDTO.setProduto(produtoDTO);
			listaCategoria.add(categoriaDTO);
		}

		produtoDTO.setCategorias(listaCategoria);
		for (Categoria categoria : listaCategoria) {
//			categoriaService.salvarCategoria(MapperDTO.INSTANCE.categoriaDTOToCategoria(categoria));
//			categoriaService.salvarCategoria(categoria);
		}

//		produtoService.salvarProduto(MapperDTO.INSTANCE.produtoDTOToProduto(produtoDTO));
		produtoService.salvarProduto(produtoDTO);
		return "redirect:/produto/cadastro";
	}
}
