package br.com.alura.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.login.LoginPage;
/*
 * Classe que testa tando a listagem de leilões
 * como o cadastro de leilão
 */
public class LeiloesTest {
	private static ListaDeLeiloesPage paginaListaDeLeiloes;
	private static CadastroLeilaoPage cadastroLeilaoPage;

	@AfterEach
	public void afterEach() {
		paginaListaDeLeiloes.encerrarNavegador();
	}
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencherUsuarioESenhaPaginaDeLogin("fulano", "pass");
		paginaListaDeLeiloes = paginaDeLogin.enviarFormularioDeLoginERetornaLeiloesPage();
		cadastroLeilaoPage = paginaListaDeLeiloes.retornaCadastroLeilaoPage(); //ponteiro para a próxima página
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		String diaDeHoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nomeLeilao = "Leilao do dia " + diaDeHoje;
		String valorInicial = "500.00";
		
		paginaListaDeLeiloes = cadastroLeilaoPage.cadastrarLeilao(nomeLeilao, valorInicial, diaDeHoje);
		Assert.assertTrue(paginaListaDeLeiloes.isLeilaoCadastrado(nomeLeilao, valorInicial, diaDeHoje));
	}
	
	/*
	 * Ao tentar cadastrar um leilão com dados inválidos
	 * não deveria deixar cadastrar o mesmo.
	 */
	@Test
	public void deveriaValidarCadastroLeilao() {
		paginaListaDeLeiloes = cadastroLeilaoPage.cadastrarLeilao("", "", ""); //selenium não aceita enviar null no send-keys dos campos
		
		//verificar se permanece na página de cadastro de leilão
		Assert.assertFalse(cadastroLeilaoPage.isPaginaAtualCadastroDeLeilao());
		
		
		//verificar se as mensagens de erro são visíveis na página
		Assert.assertTrue(cadastroLeilaoPage.isMensagensDeValidacoesVisiveis());
		
	}
}