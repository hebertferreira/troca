package troca.controller;

import org.hibernate.criterion.MatchMode;

import troca.anotacoes.Public;
import troca.hibernate.HibernateUtil;
import troca.modelo.Usuario;
import troca.sessao.SessaoUsuario;
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
	@Path("/")
	public void telaLogin() {

	}

	@Public
	public void efetuarLogin(Usuario usuario) {


//				InformacoesFixasUsuario informacoesFixasUsuario = usuarioBanco.obterInformacoesFixasUsuario();
//
//				if (Util.vazio(informacoesFixasUsuario)) {
//
//					if (!senhaInformada.equals("alabastrum")) {
//
//						codigoOuSenhaIncorretos();
//					}


			colocarUsuarioNaSessao(usuario);

			result.redirectTo(HomeController.class).home();
		}

	private void codigoOuSenhaIncorretos() {

		validator.add(new ValidationMessage("Código ou senha incorretos", "Erro"));
		validator.onErrorRedirectTo(this).telaLogin();
	}

	private void colocarUsuarioNaSessao(Usuario usuario) {

		Usuario usuarioFiltro = new Usuario();
		usuarioFiltro.setId(usuario.getId());

		usuario = (Usuario) this.hibernateUtil.selecionar(usuarioFiltro, MatchMode.EXACT);

//		usuario.setInformacoesFixasUsuario(usuario.obterInformacoesFixasUsuario());

		this.sessaoUsuario.login(usuario);
	}

	@Public
	public void logout() {

		sessaoUsuario.logout();

		result.redirectTo(this).telaLogin();
	}
}
