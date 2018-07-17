package br.ce.gsousa.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.AlertaPage;
import br.ce.gsousa.appium.page.MenuPage;

public class AlertTest extends BaseTest {
	
	private MenuPage page= new MenuPage();
	private AlertaPage alerta= new AlertaPage();
	

	@Test
	public void deveConfirmarAlerta() {
		page.acessarAlertas();
		alerta.clicarAlertaConfirm();
		
		Assert.assertEquals("Info",alerta.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?",alerta.obterMensageAlerta());
		
		alerta.confirmar();
		
		Assert.assertEquals("Confirmado",alerta.obterMensageAlerta());
		
		alerta.sair();
	}
		
}
