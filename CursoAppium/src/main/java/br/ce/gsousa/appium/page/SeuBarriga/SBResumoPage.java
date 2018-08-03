package br.ce.gsousa.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;
import br.ce.gsousa.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {
		
	public void excluirMovimetacao(String desc) {
		MobileElement elm = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(elm, 0.9, 0.1);
		clicarTexto("Del");
	}
}
