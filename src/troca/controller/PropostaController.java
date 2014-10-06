package troca.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import troca.hibernate.HibernateUtil;
import troca.modelo.Produto;
import troca.modelo.Proposta;
import troca.service.ProdutoService;
import troca.sessao.SessaoGeral;
import troca.sessao.SessaoUsuario;
import troca.util.Util;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class PropostaController {

	private SessaoUsuario sessaoUsuario;
	private SessaoGeral sessaoGeral;
	private Result result;
	private HibernateUtil hibernateUtil;

	public PropostaController(SessaoUsuario sessaoUsuario, SessaoGeral sessaoGeral, Result result, HibernateUtil hibernateUtil) {
		this.sessaoUsuario = sessaoUsuario;
		this.sessaoGeral = sessaoGeral;
		this.result = result;
		this.hibernateUtil = hibernateUtil;
	}

	// Utilizara como referencia o ID_PRODUTO
	@Path("/proposta/criarProposta/{produto.id}")
	public void criarProposta(Produto produto) {

		produto = this.hibernateUtil.selecionar(produto);
		sessaoGeral.adicionar("produto", produto);

		this.result.include("produtos", new ProdutoService().buscarProdutosDoUsuario(this.sessaoUsuario.getUsuario(), this.hibernateUtil));
	}

	public void enviarProposta(BigDecimal valor, List<Integer> produtosParaTroca) {
		
		Proposta proposta = new Proposta();
		proposta.setComprador(this.sessaoUsuario.getUsuario());
		proposta.setVendedor(((Produto) this.sessaoGeral.getValor("produto")).getUsuario());
		proposta.setProdutoLeiloado(((Produto) this.sessaoGeral.getValor("produto")));
		proposta.setValor(valor);
		proposta.setStatusProposta("Aguardando");

		// Cria lista vazia de troca
		List<Produto> itensDeTroca = new ArrayList<Produto>();

		if (Util.preenchido(produtosParaTroca)) {
			// Busca no banco os INTEGERS (idProduto) dos produtosParaTroca
			for (Integer idProduto : produtosParaTroca) {

				Produto produto = new Produto();

				// Escreve no setId o idProduto(INTEGER)
				produto.setId(idProduto);

				produto = this.hibernateUtil.selecionar(produto);

				itensDeTroca.add(produto);
			}

			// Proposta recebe os itens de troca
			proposta.setProdutos(itensDeTroca);
		}

		this.hibernateUtil.salvarOuAtualizar(proposta);

		result.include("sucesso","Proposta enviada com sucesso");
		
		result.forwardTo(this).propostasRealizadas();
	}

	public void propostasRecebidas() {

		Proposta propostaFiltro = new Proposta();
		propostaFiltro.setVendedor(this.sessaoUsuario.getUsuario());

		this.result.include("propostas", this.hibernateUtil.buscar(propostaFiltro));
	}

	@Path("/proposta/produtosDaProposta/{proposta.id}")
	public void produtosDaProposta(Proposta proposta) {

		proposta = this.hibernateUtil.selecionar(proposta);

		this.result.include("produtosDaProposta", proposta.getProdutos());
	}

	public void propostasRealizadas() {

		Proposta propostaFiltro = new Proposta();
		propostaFiltro.setComprador(this.sessaoUsuario.getUsuario());

		this.result.include("propostas", this.hibernateUtil.buscar(propostaFiltro));
	}

	@Path("/proposta/aceitar/{proposta.id}")
	public void aceitar(Proposta proposta) {

		proposta = this.hibernateUtil.selecionar(proposta);

		Proposta propostaFiltro = new Proposta();
		propostaFiltro.setProdutoLeiloado(proposta.getProdutoLeiloado());

		List<Proposta> propostas = this.hibernateUtil.buscar(propostaFiltro);

		for (Proposta propostaIteracao : propostas) {
			propostaIteracao.setStatusProposta("Rejeitado");
		}
		this.hibernateUtil.salvarOuAtualizar(propostas);

		proposta.setStatusProposta("Aceito");
		this.hibernateUtil.salvarOuAtualizar(proposta);

		result.include("sucesso","Proposta aceita com sucesso");
		
		result.forwardTo(this).propostasRecebidas();

	}

}