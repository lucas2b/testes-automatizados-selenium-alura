package br.com.alura.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
	
	private WebDriver browser;
	private static String URL_CADASTRA_LEILOES = "http://localhost:8080/leiloes/new";

	public CadastroLeilaoPage(WebDriver browser) {
		this.browser = browser;
	}
	
	public void fecharNavegador() {
		this.browser.quit();
	}

	public ListaDeLeiloesPage cadastrarLeilao(String nomeLeilao, String valorInicial, String diaDeHoje) {
		this.browser.findElement(By.id("nome")).sendKeys(nomeLeilao);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(diaDeHoje);
		
		this.browser.findElement(By.id("cadastrarLeilaoForm")).submit(); //Devolve a página de leilões
		return new ListaDeLeiloesPage(browser);
	}
	
	public boolean verificarTextoContidoNaPaginaAtual(String texto) {
		return browser.getPageSource().contains(texto);
	}
	
	
	//testes feitos por mim
	public boolean isPaginaAtualCadastroDeLeilao() {
		return this.browser.getCurrentUrl().equals(URL_CADASTRA_LEILOES);
	}

	public boolean isMensagensDeValidacoesVisiveis() {
		String pageSource = browser.getPageSource();
		return pageSource.contains("não deve estar em branco")
				&& pageSource.contains("minimo 3 caracteres")
				&& pageSource.contains("deve ser um valor maior de 0.1")
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
	

}
