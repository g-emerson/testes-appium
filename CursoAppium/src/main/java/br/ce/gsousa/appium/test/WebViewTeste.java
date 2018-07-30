package br.ce.gsousa.appium.test;

import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.MenuPage;
import br.ce.gsousa.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page =  new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		menu.acessaSBHibrido();
		esperar(6000);
		page.entrarContextoWeb();
		page.setEmail("email@em ");
		
		
		
		
	}

}
