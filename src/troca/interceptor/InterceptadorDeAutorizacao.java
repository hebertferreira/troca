package troca.interceptor;

import java.util.Arrays;

import troca.anotacoes.Public;
import troca.controller.LoginController;
import troca.sessao.SessaoUsuario;
import troca.util.Util;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Intercepts
public class InterceptadorDeAutorizacao implements Interceptor {

	private SessaoUsuario sessaoUsuario;
	private Result result;

	public InterceptadorDeAutorizacao(SessaoUsuario sessaoUsuario, Result result) {

		this.sessaoUsuario = sessaoUsuario;
		this.result = result;
	}

	public boolean accepts(ResourceMethod method) {

		boolean contemAnotacaoPublic = !method.containsAnnotation(Public.class);

		return contemAnotacaoPublic;
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) throws InterceptionException {

		if (Util.vazio(sessaoUsuario.getUsuario())) {

			usuarioNaoLogadoNoSistema();
			
		} else{

			stack.next(method, resourceInstance);
		}
	}

	private void usuarioNaoLogadoNoSistema() {

		result.include("errors", Arrays.asList(new ValidationMessage("O usuario não está logado no sistema", "Erro")));
		result.redirectTo(LoginController.class).telaLogin();
	}
}
