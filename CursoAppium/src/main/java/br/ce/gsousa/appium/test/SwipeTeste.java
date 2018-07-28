package br.ce.gsousa.appium.test;

import static br.ce.gsousa.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.gsousa.appium.core.BaseTest;
import br.ce.gsousa.appium.page.MenuPage;

public class SwipeTeste extends BaseTest {

	private MenuPage menu = new MenuPage();

	@Test
	public void deveAcessarSwipe() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		menu.scroll(0.9, 0.10);

		menu.acessarSwipe();
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		menu.swipe(0.9, 0.1);
		esperar(1000);
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		menu.clicarTexto("›");
		esperar(3000);
		//Assert.assertTrue(menu.existeElementoPorTexto("fim"));

		menu.clicarTexto("‹");
		esperar(1000);
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		menu.swipe(0.1, 0.9);
		esperar(1000);
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

	}
}
