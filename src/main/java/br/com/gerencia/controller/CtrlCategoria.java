package br.com.gerencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gerencia.constants.StaticCaminho;
import br.com.gerencia.model.Categoria;
import br.com.gerencia.service.CategoriaService;
@Controller
public class CtrlCategoria {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value = {"/cadastroCategoria"}, method = RequestMethod.POST)
	public String cadastroCategoriaPage(@ModelAttribute(value = "categoria") Categoria categoria){
		categoriaService.salvarCategoria(categoria);		
		return  "redirect:categoria";
	}
	
	@RequestMapping(value = { "/categoria" }, method = RequestMethod.GET)
	public String categoriaPage(Model model) {
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("categorias",categoriaService.listarCategorias());
		return StaticCaminho.strCaminhoControleEstoque + StaticCaminho.strCategoria + "categorias";
	}
	
	@RequestMapping(value = {"/excluirCategoria"}, method = RequestMethod.GET)
	public String excluirCategoriaPage(@RequestParam(value="chave") Long chave){
		categoriaService.exluirCategoriaPorChave(chave);
		return "redirect:categoria";
	}
	@RequestMapping(value = {"/editarCategoria"}, method = RequestMethod.POST)
	public @ResponseBody String editarCategoriaPage(@RequestBody Categoria categoria, Model model){
		categoriaService.editarCategoria(categoria);
		return "redirect:categoria";

	}
}
