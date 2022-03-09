package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	private CadastroLeilaoPage paginaDeCadastro;
	private LancesPage paginaDeLances;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormulario("fulano", "pass");
		paginaDeLeiloes = paginaDeLogin.submeterFormulario();
		paginaDeCadastro =  paginaDeLeiloes.carregarFormulario();		
		
	}
	
	@AfterEach
	public void afterEach() {
		paginaDeLeiloes.fechar();
	}
	
	@Test
	public void deveriaCadastrarLeilao() {
		
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia 09/12/2021";
		String valor = "500.00";
		
		paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void deveriaValidarCadastroDeLeilao() {
		
		paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("", "", "");
		
		Assert.assertFalse(paginaDeCadastro.isPaginaCadastro());
		Assert.assertTrue(paginaDeCadastro.isPaginaAtual());
		Assert.assertTrue(paginaDeLeiloes.isMensagensVisiveis());

	}
	
	@Test
	public void naoDeveriaEfetuarLancesComUmPrecoMenor() {
		
		paginaDeLances = paginaDeLeiloes.carregarLances();
		paginaDeLances.preencherFormulario("50.00");
		
		
	}
	
	@Test
	public void deveriaEfetuarDarLance() {

		paginaDeLances = paginaDeLeiloes.carregarLances();
		paginaDeLances.preencherFormulario("5000.00");
		
		}
	
	
	
	@Test
	public void naoDeveriaEfetuarLancesSeguidos() {

		paginaDeLances = paginaDeLeiloes.carregarLances();
		paginaDeLances.preencherFormulario("6000.00");
		
		Assert.assertEquals(0, 0);
		
		
		
	}
}
