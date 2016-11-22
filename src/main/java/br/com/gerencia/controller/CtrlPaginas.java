package br.com.gerencia.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gerencia.constants.ModeloGame;
import br.com.gerencia.constants.StaticCaminho;
import br.com.gerencia.model.Categoria;
import br.com.gerencia.model.ContaUsuario;
import br.com.gerencia.model.Produto;
import br.com.gerencia.service.ContaUsuarioService;

@Controller
public class CtrlPaginas {
	
	@Autowired
	private ContaUsuario contaUsuario;
	@Autowired
	private ContaUsuarioService contaService;


	public CtrlPaginas() {
	}

	public String getSchema() {
		String username = null;
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user instanceof UserDetails) {
			username = ((UserDetails) user).getUsername();
		}
		System.out.println(username);
		return username;
	}

	private String getPrincipal(HttpServletResponse response) {
		String username = null;
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user instanceof UserDetails) {
			username = ((UserDetails) user).getUsername();
		}

		return username;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/cad" }, method = RequestMethod.GET)
	public String cadastroConta() {

		return "index";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String welcomePage() {
		contaUsuario.setIsAtiva(true);
		contaUsuario.setNome("murílloç");
		contaUsuario.setSobrenome("costa santana ferreira");
		contaUsuario.setUsername("atsoc");
		contaUsuario.setPassword("031994");
		contaUsuario.setEmail("murillo@gmail.com");
		contaUsuario.setDataNascimento(null);
		contaUsuario.setSchema("murillo");
		contaService.salvarConta(contaUsuario);

		// RestTemplate restTemplate = new RestTemplate();
		// Quote quote = restTemplate.getForObject(
		// "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		// System.out.println(quote.getValue().getId());
		// log.info(quote.toString());
		// ProdutoJson prod =
		// restTemplate.getForObject("http://sandbox.buscape.com/service/findOfferList/754b386948454b375076673d/?barcode=7891356040757&format=json",
		// ProdutoJson.class);
		// System.out.println(prod.getProduct());
		// RestTemplate restTemplate = new RestTemplate();
		// restTemplate.getMessageConverters().add(0,
		// new StringHttpMessageConverter(Charset.forName("UTF-8")));
		// HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//
		// HttpEntity<String> entity = new HttpEntity<String>("parameters",
		// headers);
		//
		// ResponseEntity<String> result = restTemplate
		// .exchange(
		// "http://sandbox.buscape.com/service/findOfferList/754b386948454b375076673d/?barcode=7891356040757&format=json",
		// HttpMethod.GET, entity, String.class);
		//
		// ObjectMapper mapper = new ObjectMapper();
		//
		// try {
		// JsonNode js = mapper.readTree(result.getBody());
		// System.out.println(js.get("product").findParent("thumbnail")
		// .findParent("formats").findParent("url"));
		// System.out.println(js.get("product").findValues("productname"));
		// } catch (JsonProcessingException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return "index";

	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap modelAndView, HttpServletResponse response) {

		modelAndView.addAttribute("user", getPrincipal(response));
		return "home";

	}

	
	
	@RequestMapping(value = { "/estoque" }, method = RequestMethod.GET)
	public String estoquePage() {
		return StaticCaminho.strCaminhoControleEstoque + "estoque";
	}

	@RequestMapping(value = { "/movimentacoes" }, method = RequestMethod.GET)
	public String movimentacoesPage() {
		return StaticCaminho.strCaminhoControleEstoque + "movimentacoes";
	}

	@RequestMapping(value = { "/funcionario" }, method = RequestMethod.GET)
	public String funcionarioPage() {
		return StaticCaminho.strCaminhoControleVendas + "funcionario";
	}

	@RequestMapping(value = { "/vendas" }, method = RequestMethod.GET)
	public String vendasPage() {
		return StaticCaminho.strCaminhoControleVendas + "vendas";
	}

	@RequestMapping(value = { "/maquinas" }, method = RequestMethod.GET)
	public String maquinasPage(ModelMap model) {
		model.addAttribute("modelos", ModeloGame.values());
	
		return StaticCaminho.strCaminhoControleTempo + "maquinas";
	}

	@RequestMapping(value = { "/tabelaPreco" }, method = RequestMethod.GET)
	public String tabelaPrecoPage() {
		return StaticCaminho.strCaminhoControleTempo + "tabela-preco";
	}

	@RequestMapping(value = { "/temposGuardados" }, method = RequestMethod.GET)
	public String tempoGuardadoPage() {
		return StaticCaminho.strCaminhoControleTempo + "tempo-guardado";
	}

	@RequestMapping(value = { "/temposAtivos" }, method = RequestMethod.GET)
	public String tempoAtivoPage() {
		return StaticCaminho.strCaminhoControleTempo + "tempo-ativo";
	}
}
