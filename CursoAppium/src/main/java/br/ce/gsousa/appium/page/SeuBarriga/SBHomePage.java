package br.ce.gsousa.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;

public class SBHomePage extends BasePage {
	
	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}

}
