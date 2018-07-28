package br.ce.gsousa.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.CliquesPage;
import br.ce.gsousa.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Test
	public void deveRealizarCliqueLongo() {
		menu.acessarCliques();
		
		page.cliqueLongo();
		
		Assert.assertEquals("Clique Longo",page.obterTextoCampo());
	}
}
