package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObjec;

public class CadastroLeilaoPage extends PageObjec{
	
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes";

	public CadastroLeilaoPage(WebDriver browser) {
		super(browser);
	}


	public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataInicial) {
		
		browser.findElement(By.id("nome")).sendKeys(nome);
		browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
		browser.findElement(By.id("dataAbertura")).sendKeys(dataInicial);	
		browser.findElement(By.id("button-submit")).submit();
		
		return new LeiloesPage(browser);

	}

	public boolean isPaginaCadastro() {
		return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().contentEquals(URL_CADASTRO_LEILOES);
	}
	
}
