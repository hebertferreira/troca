package troca.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;

import troca.hibernate.HibernateUtil;
import troca.modelo.Produto;
import troca.service.ProdutoService;
import troca.sessao.SessaoUsuario;
import troca.util.Util;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
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

		this.result.include("produtos", new ProdutoService().buscarProdutosDoUsuario(this.sessaoUsuario.getUsuario(), this.hibernateUtil));
	}

	public void salvar(Produto produto, UploadedFile imagem) throws FileNotFoundException, IOException {

		validarProduto(produto);

		produto.setUsuario(this.sessaoUsuario.getUsuario());

		hibernateUtil.salvarOuAtualizar(produto);

		salvarImagemNoDisco(produto, imagem);

		result.forwardTo(this).acessarProduto();
	}

	private void salvarImagemNoDisco(Produto produto, UploadedFile imagem) throws IOException, FileNotFoundException {

		File fotoSalva = new File(ProdutoService.PASTA_IMAGENS + produto.getId());
		IOUtils.copyLarge(imagem.getFile(), new FileOutputStream(fotoSalva));
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

	@Path("/produto/downloadImagem/{produto.id}")
	public File foto(Produto produto) {

		if (new File(ProdutoService.PASTA_IMAGENS + produto.getId()).exists()) {

			return new File(ProdutoService.PASTA_IMAGENS + produto.getId());
		}

		return new File(ProdutoService.PASTA_IMAGENS + "Unknown.png");
	}
}