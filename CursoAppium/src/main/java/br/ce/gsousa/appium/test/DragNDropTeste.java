package br.ce.gsousa.appium.test;

import static br.ce.gsousa.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.DragNDropPage;
import br.ce.gsousa.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private DragNDropPage page = new DragNDropPage();
	
	private String[] estadoInicial = new String[] {"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para","Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,","� uma lista", "Drag em Drop!", "e arraste para","Esta", "qualquer local desejado."};
	
	@Test
	public void deveEfetuarDragNDrop() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		menu.scroll(0.9, 0.10);
		
		menu.acessarDragNDrop();
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		page.arrastar("Esta", "e arraste para");
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		page.arrastar("Fa�a um clique longo,", "� uma lista");
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
		
	}
}
