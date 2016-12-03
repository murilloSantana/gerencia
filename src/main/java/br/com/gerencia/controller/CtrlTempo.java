package br.com.gerencia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.gerencia.constants.ModeloGame;
import br.com.gerencia.constants.StaticCaminho;
import br.com.gerencia.model.ItemTransacao;
import br.com.gerencia.model.Transacao;
import br.com.gerencia.model.loja.Maquina;
import br.com.gerencia.model.loja.ValorHora;
import br.com.gerencia.service.ItemTransacaoService;
import br.com.gerencia.service.TransacaoService;
import br.com.gerencia.service.loja.MaquinaService;
import br.com.gerencia.service.loja.ValorHoraService;
import br.com.gerencia.util.FormatadorUtil;

@Controller
@RequestMapping("/tempo")
public class CtrlTempo {
	@Autowired
	private ValorHoraService valorHoraService;
	@Autowired
	private FormatadorUtil formatadorUtil;
	@Autowired
	private MaquinaService maquinaService;
	@Autowired
	private ItemTransacaoService itemTransacaoService;
	@Autowired
	private TransacaoService transacaoService;

	@RequestMapping(value = { "/tabelaPreco" }, method = RequestMethod.GET)
	public String tabelaPrecoPage(ModelMap model) {
		model.addAttribute("modelos", ModeloGame.values());
		model.addAttribute("valorHora", new ValorHora());
		model.addAttribute("valores", valorHoraService.listarValorHora());
		return StaticCaminho.strCaminhoControleTempo + "tabela-preco";
	}

	@RequestMapping(value = { "/temposAtivos" }, method = RequestMethod.GET)
	public ModelAndView tempoAtivoPage(ModelMap model, HttpServletRequest request, ModelAndView modelAndView) {
		List<ValorHora> valores = null;

		modelAndView.addObject("valores", valores == null ? valorHoraService.listarValorHora() : valores);
		model.addAttribute("maquinas", maquinaService.listarMaquinas());
		model.addAttribute("transacoes", transacaoService.transacoesAtivas());	
		modelAndView.setViewName(StaticCaminho.strCaminhoControleTempo + "tempo-ativo");
		
		
		return modelAndView;
	}

	@RequestMapping(value = { "/salvarTempoAtivo" }, method = RequestMethod.POST)
	public String salvarTempoAtivo(@ModelAttribute("itemTransacao") ItemTransacao itemTransacao,
			@ModelAttribute("chaveMaquina") Long maquinaChave) {

		//verificando se a transacao esta ativa 
		if(transacaoService.isTransacaoAtiva(maquinaService.pesquisarMaquinaPorChave(maquinaChave).getNumero())){
			System.out.println("bladeeeeeeeeeeeeeeeeeeeeeeee");
		}else{
			
			List<ItemTransacao> itens = new ArrayList<ItemTransacao>();

			itemTransacao.setMaquina(maquinaService.pesquisarMaquinaPorChave(maquinaChave));
			itemTransacao.setHoraInicio(itemTransacaoService.calcularTempo());
			itemTransacao.setHoraFim(itemTransacaoService.calcularTempo().plusMinutes(itemTransacao.getMinuto()));

			itens.add(itemTransacao);
			Transacao transacao = new Transacao(itemTransacao.getHoraInicio(), "Transacao de tempo",
					itemTransacao.getPrecoUnitario(), false, null, true, itens);

			itemTransacao.setTransacao(transacao);
			itemTransacaoService.salvarItemTransacao(itemTransacao);
		}
		


		return "redirect:/tempo/temposAtivos";
	}

	@RequestMapping(value = { "/atualizarListaValorHora" }, method = RequestMethod.GET)
	public @ResponseBody List<ValorHora> atualizarListaValorHora(@RequestParam("numero") Integer numero,
			HttpServletResponse response) {
		List<ValorHora> valores = null;
		try {

			if (maquinaService.isMaquinaExists(numero)) {
				Maquina maquina = maquinaService.pesquisarMaquinaPorNome("numero", numero).get(0);
				valores = valorHoraService.pesquisarValorHoraPorNome("modelo", maquina.getModelo());

			} else {
				System.out.println("error");
			}
		} catch (Exception e) {
		}
		return valores;

	}

	@RequestMapping(value = { "/salvarValorHora" }, method = RequestMethod.POST)
	public String salvarValorHora(@ModelAttribute("valorHora") ValorHora valorHora) {
		valorHora.setPreco(formatadorUtil.StringToDouble(valorHora.getPrecoNoFormatado()));
		valorHoraService.salvarValorHora(valorHora);
		return "redirect:/tempo/tabelaPreco";
	}

}
