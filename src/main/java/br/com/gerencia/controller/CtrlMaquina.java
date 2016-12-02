package br.com.gerencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gerencia.constants.ModeloGame;
import br.com.gerencia.constants.StaticCaminho;
import br.com.gerencia.model.loja.Maquina;
import br.com.gerencia.service.loja.MaquinaService;
@Controller
@RequestMapping("/maquina")
public class CtrlMaquina {


	@Autowired
	private MaquinaService maquinaService;
	
	@RequestMapping(value = { "/lista" }, method = RequestMethod.GET)
	public String maquinasPage(ModelMap model) {
		model.addAttribute("modelos", ModeloGame.values());
		model.addAttribute("maquina", new Maquina());
		model.addAttribute("maquinas", maquinaService.listarMaquinas());
		return StaticCaminho.strCaminhoControleTempo + "maquinas";
	}
	@RequestMapping(value={"/salvar"}, method= RequestMethod.POST)
	public String salvarMaquina(@ModelAttribute("maquina") Maquina maquina){
		maquinaService.salvarMaquina(maquina);
		return "redirect:/maquina/lista";
	}
}
