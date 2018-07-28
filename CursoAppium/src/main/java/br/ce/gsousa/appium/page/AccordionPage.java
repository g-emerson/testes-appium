package br.ce.gsousa.appium.page;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;

public class AccordionPage extends BasePage {

	public void selecionarOpc1() {
		clicarTexto("Op��o 1");
	}
	
	public String obterValorOpc1() {
		return obterTexto(By.xpath("//*[@text='Op��o 1']/../..//following-sibling::android.view.ViewGroup//android.widget.TextView"));
	}
}
