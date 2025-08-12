package br.com.alura.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	private static LoginPage loginPage;

	@BeforeEach
	public void beforeEach() {
		loginPage = new LoginPage();
	}

	@AfterEach
	public void afterEach() {
		loginPage.encerrarNavegador();
	}

	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		loginPage.preencherUsuarioESenhaPaginaDeLogin("fulano", "pass");
		loginPage.enviarFormularioDeLoginERetornaLeiloesPage();

		Assert.assertEquals(loginPage.recuperarPaginaAtual(), LoginPage.URL_LEILOES); 
		Assert.assertEquals(loginPage.recuperarTextoUsuarioLogado(), "fulano"); 
	}

	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		loginPage.preencherUsuarioESenhaPaginaDeLogin("invalido", "123");
		loginPage.enviarFormularioDeLoginERetornaLeiloesPage();

		Assert.assertEquals(loginPage.recuperarPaginaAtual(), LoginPage.URL_LOGIN_ERROR);
		Assert.assertTrue(loginPage.verificarTextoContidoNaPaginaAtual("Usuário e senha inválidos."));
		Assert.assertNull(loginPage.recuperarTextoUsuarioLogado());
	}

	@Test
	public void naoDeveriaAcessarPaginaRestristaSemEstarLogado() {
		loginPage.navegarParaURL(LoginPage.URL_LEILAO_ID_2);

		Assert.assertEquals(loginPage.recuperarPaginaAtual(), LoginPage.URL_LOGIN);
		Assert.assertFalse(loginPage.verificarTextoContidoNaPaginaAtual("Dados do Leilão"));
	}
}