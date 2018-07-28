package br.ce.gsousa.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.CliquesPage;
import br.ce.gsousa.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Before
	public void setup() {
		menu.acessarCliques();
	}	
	
	@Test
	public void deveRealizarCliqueLongo() {
		page.cliqueLongo();
		
		Assert.assertEquals("Clique Longo",page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarTexto("Clique duplo");
		page.clicarTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique",page.obterTextoCampo());
	}
}
