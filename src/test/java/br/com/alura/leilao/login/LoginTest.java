package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;

	@BeforeEach
	public void beforeEach() {
		paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		paginaDeLogin.fechar();
	}
	
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		
		paginaDeLogin.preencheFormulario("fulano", "pass");
		paginaDeLogin.submeterFormulario();
		
		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
		
	}
	
	@Test
	public void naoDeveriaLogarComDadosInvalisdos(){
		
		paginaDeLogin.preencheFormulario("invalido", "123123");
		paginaDeLogin.submeterFormulario();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
		
	}
	
	@Test
	public void naoDeveriaAcessarPaginaSemEstarLogado() {
		
		paginaDeLogin.navegaParaPaginaDeLances();
		
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
		
	}
	
}

