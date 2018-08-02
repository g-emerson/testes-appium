package br.ce.gsousa.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.MenuPage;
import br.ce.gsousa.appium.page.SeuBarriga.SBContasPage;
import br.ce.gsousa.appium.page.SeuBarriga.SBLoginPage;
import br.ce.gsousa.appium.page.SeuBarriga.SBMenuPage;
import br.ce.gsousa.appium.page.SeuBarriga.SBMovimentacaoPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSb = new SBMenuPage();
	private SBContasPage contasSb = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();

	@Before
	public void setup() {
		menu.acessaSBNativo();
		login.setEmail("em@em");
		login.setSenha("1");
		login.entrar();
	}

	@Test
	public void deveInserirContaComSucesso() {
		menuSb.acessarContas();
		contasSb.setConta("Conta de Teste");
		contasSb.salvar();

		Assert.assertTrue(contasSb.existeElementoPorTexto("Conta adicionada com sucesso"));

	}

	@Test
	public void deveExcluirContaComSucesso() {
		menuSb.acessarContas();
		contasSb.selecionarContas("Conta para alterar");
		contasSb.excluir();
		
		Assert.assertTrue(contasSb.existeElementoPorTexto("Conta exclu�da com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov() {
		menuSb.acessarMovimentacoes();
		
		mov.salvar();
		Assert.assertTrue(contasSb.existeElementoPorTexto("Descri��o � um campo obrigat�rio"));
		
		mov.setDescricao("Descri");
		mov.salvar();
		Assert.assertTrue(contasSb.existeElementoPorTexto("Interessado � um campo obrigat�rio"));
		
		mov.setInteressado("Interess");
		mov.salvar();
		Assert.assertTrue(contasSb.existeElementoPorTexto("Valor � um campo obrigat�rio"));
		
		mov.setValor("100");
		mov.salvar();
		Assert.assertTrue(contasSb.existeElementoPorTexto("Conta � um campo obrigat�rio"));
		
		mov.setConta("Conta para alterar");
		mov.salvar();
		Assert.assertTrue(contasSb.existeElementoPorTexto("Movimenta��o cadastrada com sucesso"));
		
		
		
	}

	
	//Descri��o � um campo obrigat�rio
}
