package br.ce.gsousa.appium.page;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;

public class AbasPage extends BasePage {
	
	public boolean isAba1() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 1");
	}
	
	public boolean isAba2() {
		return existeElementoPorTexto("Este é o conteúdo da Aba 2");
	}
	
	public void deveClicarAba1() {
		clicarTexto("ABA 1");
	}
	
	public void deveClicarAba2() {
		clicarTexto("ABA 2");
	}
	
	
	public String obterConteudo() {
		return obterTexto(By.xpath("//android.view.ViewGroup/android.widget.TextView"));
	}
	
}
