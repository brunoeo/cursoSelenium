package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObjec;

public class LeiloesPage extends PageObjec{

	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_DAR_LANCES = "http://localhost:8080/leiloes/2";


	public LeiloesPage(WebDriver browser) {
		super(browser);
	}

	public CadastroLeilaoPage carregarFormulario() {
		browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);
	}

	public boolean isLeilaoCadastrado(String nome, String valor, String hoje) {
		WebElement linhaDaTabela = browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome)
				&& colunaDataAbertura.getText().equals(hoje)
				&& colunaValorInicial.getText().equals(valor);
	}

	public boolean isMensagensVisiveis() {
		String pageSource = browser.getPageSource();
		return pageSource.contains("não deve estar em branco")
				&& pageSource.contains("minimo 3 caracteres")
				&& pageSource.contains("deve ser um valor maior de 0.1")
				&& pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}

	public LancesPage carregarLances() {
		browser.navigate().to(URL_DAR_LANCES);
		return new LancesPage(browser);
	}

	

}
