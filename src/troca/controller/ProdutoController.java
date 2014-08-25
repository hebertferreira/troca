package troca.controller;

import troca.hibernate.HibernateUtil;
import troca.modelo.Produto;
import troca.util.Util;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class ProdutoController {

	private Result result;
	private Validator validator;
	private HibernateUtil hibernateUtil;
	
	public ProdutoController(Result result, Validator validator, HibernateUtil hibernateUtil) {
		this.result = result;
		this.validator = validator;
		this.hibernateUtil = hibernateUtil;
	}
		
	public void acessarProduto(){
		
		
	}
	
	public void salvar(Produto produto){
		
		if (Util.vazio(produto.getNome())) {
			validator.add(new ValidationMessage("Ops...preencha o campo nome", "Erro"));
		}
	
		if (Util.vazio(produto.getDescricao())) {
			validator.add(new ValidationMessage("Ops...campo descriçao é obrigatório", "Erro"));
		}

		validator.onErrorRedirectTo(this).acessarProduto();

	}
}