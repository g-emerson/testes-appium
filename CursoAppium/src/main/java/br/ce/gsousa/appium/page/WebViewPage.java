package br.ce.gsousa.appium.page;

import static br.ce.gsousa.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;
import br.ce.gsousa.appium.core.DriverFactory;

public class WebViewPage extends BasePage {

	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
		for (String valor : contextHandles) {
			System.out.print(valor);
			System.out.print(contextHandles);
		}
		// getDriver().context((String)contextHandles.toArray()[1]);
	}

	public void setEmail(String email) {
		getDriver().findElement(By.id("email")).sendKeys(email);
	}

	public void setSenha(String senha) {
		getDriver().findElement(By.id("senha")).sendKeys(senha);
	}

	public void sairContextoWeb() {
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
	}

	public String getMensagem() {
		return obterTexto(By.xpath("//*/div[@class='alert alert-sucess']"));
	}
	
	public boolean getMensagem2(String texto) {
		return existeElementoPorTexto(texto);
	}	

	public void entrar() {
		clicarTexto("Entrar");
	}

}
