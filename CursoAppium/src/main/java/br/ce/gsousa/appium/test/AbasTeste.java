package br.ce.gsousa.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.AbasPage;
import br.ce.gsousa.appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	private MenuPage page = new MenuPage();
	private AbasPage abas = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		page.acessarAbas();
		//verificar que esta na aba 1
		//abas.deveClicarAba1();
		Assert.assertTrue(abas.isAba1());
		
		//acessar aba 2 
		abas.deveClicarAba2();
		//verificar que esta na aba 2
		Assert.assertTrue(abas.isAba2());
	}

}
