package br.ce.gsousa.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.gsousa.appium.core.DriverFactory;
import br.ce.gsousa.appium.page.FormularioPage;
import br.ce.gsousa.appium.page.MenuPage;

public class FormularioTeste {
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		//driver = DriverFactory.getDriver();   
		menu.acessarFormulario();	  	    
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}	
	
	@Test
	public  void devePreencherCampoTexto() throws MalformedURLException {
	    page.escreverNome("Gerry");
	   
	    assertEquals("Gerry", page.obterNome());
	}
	
	@Test
	public  void deveInteragirComCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");

		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}
	
	@Test
	public  void deveInteragirComSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());
		
		page.clicarCheck();
		page.clicarSwitch();
		
		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());
	}
	
	@Test
	public  void deveRealizarrCadastro() throws MalformedURLException {
		page.escreverNome("Gerry");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("PS4");
		page.salvar();
	
	    assertEquals("Nome: Gerry", page.obterNomeCadastrato());
	    assertEquals("Console: ps4", page.obterConsoleCadastrado());
	    assertTrue(page.obterCheckCadastrado().endsWith("Off"));
	    assertTrue(page.obterSwithCadastrado().endsWith("Marcado"));
		}
}
