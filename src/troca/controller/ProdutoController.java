package troca.controller;

import java.util.List;

import troca.anotacoes.Public;
import troca.hibernate.HibernateUtil;
import troca.modelo.Produto;
import troca.sessao.SessaoUsuario;
import troca.util.Util;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class ProdutoController {
	
	private SessaoUsuario sessaoUsuario;
	private Result result;
	private Validator validator;
	private HibernateUtil hibernateUtil;

	public ProdutoController(SessaoUsuario sessaoUsuario, Result result, Validator validator, HibernateUtil hibernateUtil) {
		this.sessaoUsuario = sessaoUsuario;
		this.result = result;
		this.validator = validator;
		this.hibernateUtil = hibernateUtil;
	}

	public void acessarProduto() {
		
		Produto produtoFiltro = new Produto();
		produtoFiltro.setUsuario(this.sessaoUsuario.getUsuario());
		
		List<Produto> produtos = this.hibernateUtil.buscar(produtoFiltro);
		
		this.result.include("produtos", produtos);
	}


	public void salvar(Produto produto) {

		validarProduto(produto);
		
		produto.setUsuario(this.sessaoUsuario.getUsuario());
		
		hibernateUtil.salvarOuAtualizar(produto);
		
		result.forwardTo(ProdutoController.class).acessarProduto();
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
	
	public void pesquisarProduto(String pesquisa){
		
		if(Util.preenchido(pesquisa)){
			
			Produto produtoFiltro = new Produto();
			
			produtoFiltro.setNome(pesquisa);
			
			List<Produto> produtos = this.hibernateUtil.buscar(produtoFiltro);
			
			this.result.include("produtos", produtos);
		}
	}
}