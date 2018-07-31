package br.ce.gsousa.appium.page;

import static br.ce.gsousa.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;

public class SBLoginPage extends BasePage {
	
	public void setEmail(String email) {
		escrever(By.className("android.widget.EditText"), email);
	}

	public void setSenha(String senha) {
		escrever(By.xpath("//android.widget.EditText[2]"), senha);
	}
	
	public void entrar() {
		clicarTexto("ENTRAR");
	}

}
