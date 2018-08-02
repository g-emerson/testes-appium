package br.ce.gsousa.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.MenuPage;
import br.ce.gsousa.appium.page.SeuBarriga.SBContasPage;
import br.ce.gsousa.appium.page.SeuBarriga.SBLoginPage;
import br.ce.gsousa.appium.page.SeuBarriga.SBMenuPage;

public class SBTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSb = new SBMenuPage();
	private SBContasPage contasSb = new SBContasPage();

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
		
		Assert.assertTrue(contasSb.existeElementoPorTexto("Conta excluída com sucesso"));
	}

}
