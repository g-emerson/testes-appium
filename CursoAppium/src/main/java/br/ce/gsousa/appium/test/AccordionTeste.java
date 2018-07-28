package br.ce.gsousa.appium.test;

import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.AccordionPage;
import br.ce.gsousa.appium.page.MenuPage;
import org.junit.Assert;

public class AccordionTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		
		menu.acessarAccordion();
		page.selecionarOpc1();
		esperar(1000);
		
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOpc1()); 		

	}
}
