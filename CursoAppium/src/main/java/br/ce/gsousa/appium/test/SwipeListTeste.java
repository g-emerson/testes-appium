package br.ce.gsousa.appium.test;

import static br.ce.gsousa.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.MenuPage;
import br.ce.gsousa.appium.page.SwipeListPage;

public class SwipeListTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Test
	public void deveIntaragirSwipeList() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		menu.scroll(0.9, 0.10);
		menu.acessarSwipeList();

		page.swipeElementRight("Op��o 1");
		page.clicarBotaoMais();
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));
		
		page.swipeElementRight("Op��o 4");
		page.clicarTexto("(-)");
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 4 (-)"));
		
		page.swipeElementLeft("Op��o 5 (-)");
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 5"));
	}

}
