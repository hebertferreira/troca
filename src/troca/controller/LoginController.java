package troca.controller;

import org.hibernate.criterion.MatchMode;

import troca.anotacoes.Public;
import troca.hibernate.HibernateUtil;
import troca.modelo.Usuario;
import troca.sessao.SessaoUsuario;
import troca.util.GeradorDeMd5;
import troca.util.Util;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class LoginController {

	private final Result result;
	private SessaoUsuario sessaoUsuario;
	private Validator validator;
	private HibernateUtil hibernateUtil;

	public LoginController(Result result, SessaoUsuario sessaoUsuario, Validator validator, HibernateUtil hibernateUtil) {
		this.result = result;
		this.sessaoUsuario = sessaoUsuario;
		this.validator = validator;
		this.hibernateUtil = hibernateUtil;
	}

	@Public
	public void criar(Usuario usuario) {

		validarPreenchimento(usuario);
		validarEmailExistente(usuario);
		
		criptografarSenha(usuario);

		this.hibernateUtil.salvarOuAtualizar(usuario);
		colocarUsuarioNaSessao(usuario);
		result.redirectTo(ProdutoController.class).acessarProduto();
	}

	private void criptografarSenha(Usuario usuario) {
		usuario.setSenha(GeradorDeMd5.converter(usuario.getSenha()));
	}

	private void validarPreenchimento(Usuario usuario) {

		if (Util.vazio(usuario.getEmail())) {
			validator.add(new ValidationMessage("Preencha o campo email", "Erro"));
		}

		if (Util.vazio(usuario.getNome())) {
			validator.add(new ValidationMessage("Preencha o campo nome", "Erro"));
		}

		if (Util.vazio(usuario.getSenha())) {
			validator.add(new ValidationMessage("Preencha o campo senha", "Erro"));
		}

		validator.onErrorRedirectTo(this).telaLogin();
	}

	public void validarEmailExistente(Usuario usuario) {

		Usuario usuarioFiltro = new Usuario();
		usuarioFiltro.setEmail(usuario.getEmail());

		if (this.hibernateUtil.contar(usuarioFiltro, MatchMode.EXACT) > 0) {
			validator.add(new ValidationMessage("Já existe um usuário com este email cadastrado", "Validacao"));
		}

		validator.onErrorRedirectTo(this).telaLogin();
	}

	@Public
	@Path("/")
	public void telaLogin() {

	}

	@Public
	public void efetuarLogin(Usuario usuario) {

		criptografarSenha(usuario);
		
		validarEmailLogin(usuario);

		colocarUsuarioNaSessao(usuario);

		result.redirectTo(ProdutoController.class).acessarProduto();
	}

	public void validarEmailLogin(Usuario usuario) {

		Usuario usuarioFiltro = new Usuario();
		usuarioFiltro.setEmail(usuario.getEmail());
		usuarioFiltro.setSenha(usuario.getSenha());

		if (this.hibernateUtil.contar(usuarioFiltro, MatchMode.EXACT) == 0) {
			validator.add(new ValidationMessage("Login ou senha estão incorretos", "Validacao"));
		}

		validator.onErrorRedirectTo(this).telaLogin();
	}

	private void colocarUsuarioNaSessao(Usuario usuario) {

		this.sessaoUsuario.login((Usuario) this.hibernateUtil.selecionar(usuario, MatchMode.EXACT));
	}
}
