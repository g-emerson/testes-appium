package br.ce.gsousa.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.MenuPage;
import br.ce.gsousa.appium.page.SBLoginPage;


public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBLoginPage login =  new SBLoginPage();
	
	@Before
	public void setup() {
		menu.acessaSBNativo();
		login.setEmail("em@em");
		login.setSenha("1");
		login.entrar();		
	}
	
	@Test
	public void test() {
		
	}

}
