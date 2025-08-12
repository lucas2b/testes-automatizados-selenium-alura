package br.com.alura.login;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import br.com.alura.leiloes.ListaDeLeiloesPage;

public class LoginPage {

	public static String URL_LOGIN = "http://localhost:8080/login";
	public static String URL_LEILOES = "http://localhost:8080/leiloes";
	public static String URL_LEILAO_ID_2 = "http://localhost:8080/leiloes/2";
	public static String URL_LOGIN_ERROR = "http://localhost:8080/login?error";
	private WebDriver browser;
	private static ChromeOptions options;

	public LoginPage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lucas\\eclipse-workspace\\2019-selenium-java-projeto_inicial\\drivers\\chromedriver.exe");
		options = new ChromeOptions();
		options.setExperimentalOption("prefs", new HashMap<String, Object>() {
			{
				put("credentials_enable_service", false);
				put("profile.password_manager_enabled", false);
				put("profile.password_manager_leak_detection", false);
			}
		});
		
		//Modo headless (sem abrir o navegador)
		//options.addArguments("--headless"); // executa sem abrir janela
	    //options.addArguments("--disable-gpu"); // em algumas plataformas pode ser necessário
	    //options.addArguments("--window-size=1920,1080");

		this.browser = new ChromeDriver(options);
		this.browser.navigate().to(URL_LOGIN);
	}

	public void encerrarNavegador() {
		this.browser.quit();
	}

	public void preencherUsuarioESenhaPaginaDeLogin(String usuario, String senha) {
		browser.findElement(By.id("username")).sendKeys(usuario); // preencher input username
		browser.findElement(By.id("password")).sendKeys(senha); // preencher input password
	}

	public ListaDeLeiloesPage enviarFormularioDeLoginERetornaLeiloesPage() {
		browser.findElement(By.id("login-form")).submit(); // submit no form de login
		return new ListaDeLeiloesPage(browser);
	}

	public String recuperarPaginaAtual() {
		return browser.getCurrentUrl();
	}

	public String recuperarTextoUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean verificarTextoContidoNaPaginaAtual(String texto) {
		return browser.getPageSource().contains(texto);
	}
	
	public void navegarParaURL(String url) {
		this.browser.navigate().to(url);
	}

}
