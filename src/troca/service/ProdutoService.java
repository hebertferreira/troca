package troca.service;

import java.util.List;

import troca.hibernate.HibernateUtil;
import troca.modelo.Produto;
import troca.modelo.Usuario;

public class ProdutoService {

	public static final String PASTA_IMAGENS = "/imagens-sistema-troca/";

	public List<Produto> buscarProdutosDoUsuario(Usuario usuario, HibernateUtil hibernateUtil) {

		Produto produtoFiltro = new Produto();
		produtoFiltro.setUsuario(usuario);
		return hibernateUtil.buscar(produtoFiltro);
	}
}