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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

import br.com.gerencia.DAO.ProdutoDAO;
import br.com.gerencia.constants.ModeloGame;
import br.com.gerencia.constants.StaticCaminho;
import br.com.gerencia.model.ItemTransacao;
import br.com.gerencia.model.Produto;
import br.com.gerencia.model.Transacao;
import br.com.gerencia.model.loja.Maquina;
import br.com.gerencia.model.loja.ValorHora;
import br.com.gerencia.service.CategoriaService;
import br.com.gerencia.service.ItemTransacaoService;
import br.com.gerencia.service.ProdutoService;
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
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private ProdutoDAO produtoDAO;
	// @Autowired
	// private MapperProduto mapper;
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
		model.addAttribute("itemTransacao", new ItemTransacao());
		model.addAttribute("produto", new Produto());
		modelAndView.setViewName(StaticCaminho.strCaminhoControleTempo + "tempo-ativo");

		return modelAndView;
	}

	@RequestMapping(value = { "/salvarTempoAtivo" }, method = RequestMethod.POST)
	public String salvarTempoAtivo(@ModelAttribute("itemTransacao") ItemTransacao itemTransacao,
			@ModelAttribute("chaveMaquina") Long maquinaChave) {

		Transacao transacao;
		Maquina maquina = maquinaService.pesquisarMaquinaPorChave(maquinaChave);
		List<ItemTransacao> itens = new ArrayList<ItemTransacao>();

		itemTransacao.setMaquina(maquina);
		itemTransacao.setHoraInicio(itemTransacaoService.calcularTempo());
		itemTransacao.setHoraFim(itemTransacaoService.calcularTempo().plusMinutes(itemTransacao.getMinuto()));
		itemTransacao.setDataTransacao(itemTransacaoService.calcularTempo());
		itens.add(itemTransacao);

		// verificando se a transacao esta ativa, se estiver é retornado uma
		// transacao para o atributo
		if ((transacaoService.isTransacaoAtiva(maquinaChave.intValue())) != null) {

			transacao = transacaoService.isTransacaoAtiva(maquinaChave.intValue());
			transacao.setItensTransacao(itens);
			itemTransacao.setTransacao(transacao);
			transacaoService.salvarTransacao(transacao);
		} else {

			transacao = new Transacao(itemTransacao.getHoraInicio(), "Transacao de tempo",
					itemTransacao.getPrecoUnitario(), false, null, true, itens);

			itemTransacao.setTransacao(transacao);
			itemTransacaoService.salvarItemTransacao(itemTransacao);
		}

		return "redirect:/tempo/temposAtivos";
	}

	@RequestMapping(value = { "/salvarProdutoAtivo" }, method = RequestMethod.POST)
	public String salvarProdutoAtivo(@ModelAttribute("produto") Produto produto,
			@ModelAttribute("quantidade") String quantidade, @ModelAttribute("chaveMaquina") Long maquinaChave) {

		produto = produtoService.pesquisarProdutoPorChave(produto.getChaveProduto());
		Maquina maquina = maquinaService.pesquisarMaquinaPorChave(maquinaChave);
		Transacao transacao;
		ItemTransacao itemTransacao = new ItemTransacao();
		List<ItemTransacao> itens = new ArrayList<ItemTransacao>();

		if ((transacaoService.isTransacaoAtiva(maquinaChave.intValue())) != null) {
			itemTransacao.setMaquina(maquina);
			itemTransacao.setDataTransacao(itemTransacaoService.calcularTempo());
			itemTransacao.setProduto(produto);
			itemTransacao.setQuantidade(Integer.parseInt(quantidade));
			itens.add(itemTransacao);

			transacao = transacaoService.isTransacaoAtiva(maquinaChave.intValue());
			transacao.setItensTransacao(itens);
			itemTransacao.setTransacao(transacao);
			transacaoService.salvarTransacao(transacao);
		}
		return "redirect:/tempo/temposAtivos";
	}

	@RequestMapping(value = { "/atualizarListaValorHora" }, method = RequestMethod.GET)
	public @ResponseBody List<ValorHora> atualizarListaValorHora(@RequestParam("chaveMaquina") Integer chaveMaquina,
			HttpServletResponse response) {
		List<ValorHora> valores = null;
		try {
			Maquina maquina = maquinaService.pesquisarMaquinaPorChave(chaveMaquina.longValue());

			if (maquina != null) {
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

	@RequestMapping(value = { "/carregarProdutos" }, method = RequestMethod.GET)
	public @ResponseBody String carregarProdutos(HttpServletResponse response) {
		List<Produto> produtos = new ArrayList<Produto>();
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
//		produtos = produtoService.listarProdutos();
		// produtos.get(0).setCategorias(null);
		// System.out.println(
		// MapperDTO.INSTANCE.produtoToProdutoDTO(produtos.get(0)).getNomeProduto());
		// model.addObject("produtos", produtos);
//		return MapperDTO.INSTANCE.produtoToProdutoDTO(produtoDAO.listarProdutosSemCategoria().get(0));
		String result =null;
		ObjectMapper mapper = new ObjectMapper();
		Hibernate4Module hbm = new Hibernate4Module();
		hbm.enable(Hibernate4Module.Feature.FORCE_LAZY_LOADING);
		mapper.registerModule(hbm);

		ObjectWriter w = mapper.writer();

		try {
			result = w.writeValueAsString( produtoDAO.listarProdutos());
			System.out.println(result);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
