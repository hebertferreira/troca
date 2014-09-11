package troca.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import troca.hibernate.HibernateUtil;
import troca.modelo.Produto;
import troca.modelo.Proposta;
import troca.sessao.SessaoGeral;
import troca.sessao.SessaoUsuario;
import troca.util.Util;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class ProdutoController {

	private SessaoUsuario sessaoUsuario;
	private SessaoGeral sessaoGeral;
	private Result result;
	private Validator validator;
	private HibernateUtil hibernateUtil;

	public ProdutoController(SessaoUsuario sessaoUsuario, SessaoGeral sessaoGeral, Result result, Validator validator, HibernateUtil hibernateUtil) {
		this.sessaoUsuario = sessaoUsuario;
		this.sessaoGeral = sessaoGeral;
		this.result = result;
		this.validator = validator;
		this.hibernateUtil = hibernateUtil;
	}

	public void acessarProduto() {

		buscarProdutosDoUsuario();
	}

	private void buscarProdutosDoUsuario() {

		Produto produtoFiltro = new Produto();

		// Captura o usuário que está usando para utilizar neste método
		produtoFiltro.setUsuario(this.sessaoUsuario.getUsuario());

		// busca os produtos do usuário capturado
		List<Produto> produtos = this.hibernateUtil.buscar(produtoFiltro);

		this.result.include("produtos", produtos);
	}

	public void salvar(Produto produto) {

		validarProduto(produto);

		produto.setUsuario(this.sessaoUsuario.getUsuario());

		hibernateUtil.salvarOuAtualizar(produto);

		result.forwardTo(this).acessarProduto();
	}

	private void validarProduto(Produto produto) {
		if (Util.vazio(produto.getNome())) {
			validator.add(new ValidationMessage("Ops...preencha o campo nome", "Erro"));
		}

		if (Util.vazio(produto.getDescricao())) {
			validator.add(new ValidationMessage("Ops...campo descriçao é obrigatório", "Erro"));
		}

		validator.onErrorRedirectTo(this).acessarProduto();
	}

	public void pesquisarProduto(String pesquisa) {

		if (Util.preenchido(pesquisa)) {

			Produto produtoFiltro = new Produto();

			produtoFiltro.setNome(pesquisa);

			List<Produto> produtos = this.hibernateUtil.buscar(produtoFiltro);

			this.result.include("produtos", produtos);
		}

	}

	@Path("/produto/deletarProduto/{produto.id}")
	public void deletarProduto(Produto produto) {

		produto = this.hibernateUtil.selecionar(produto);

		if (produto.getUsuario().getId() == this.sessaoUsuario.getUsuario().getId()) {

			this.hibernateUtil.deletar(produto);

		}
		result.forwardTo(this).acessarProduto();
	}

	// Utilizara como referencia o ID_PRODUTO
	@Path("/produto/criarProposta/{produto.id}")
	public void criarProposta(Produto produto) {

		// Utiliza como
		// referencia de
		// busca o produto
		// passado no
		// PRODUTO.ID da JSP
		produto = this.hibernateUtil.selecionar(produto);
		sessaoGeral.adicionar("produto", produto);

		buscarProdutosDoUsuario();
	}

	public void enviarProposta(BigDecimal valor, List<Integer> produtosParaTroca) {

		Proposta proposta = new Proposta();
		proposta.setComprador(this.sessaoUsuario.getUsuario());
		proposta.setVendedor(((Produto) this.sessaoGeral.getValor("produto")).getUsuario());
		proposta.setProdutoLeiloado(((Produto) this.sessaoGeral.getValor("produto")));
		proposta.setValor(valor);
		
		//Cria lista vazia de troca
		List<Produto> itensDeTroca = new ArrayList<Produto>();

		// Busca no banco os INTEGERS (idProduto) dos produtosParaTroca
		for (Integer idProduto : produtosParaTroca) {

			Produto produto = new Produto();
			
			//Escreve no setId o idProduto(INTEGER)
			produto.setId(idProduto);

		
			produto = this.hibernateUtil.selecionar(produto);
			
			itensDeTroca.add(produto);
		}
		
		//Proposta recebe os itens de troca
		proposta.setProdutos(itensDeTroca);

		this.hibernateUtil.salvarOuAtualizar(proposta);
	}
}