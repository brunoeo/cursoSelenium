package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObjec;

public class LancesPage extends PageObjec{
	
	private static final String URL_DAR_LANCES = "http://localhost:8080/leiloes/2";

	public LancesPage(WebDriver browser) {
		super(browser);
	}

	public boolean isPaginaDeLances() {
		return browser.getCurrentUrl().equals(URL_DAR_LANCES);
	}

	public void preencherFormulario(String valor) {
		browser.findElement(By.id("valor")).sendKeys(valor);
		browser.findElement(By.id("btnDarLance")).submit();
		
	}

	

}
