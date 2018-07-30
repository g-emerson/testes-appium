package br.ce.gsousa.appium.page;

import static br.ce.gsousa.appium.core.DriverFactory.getDriver;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;

public class WebViewPage extends BasePage {
	
	public void entrarContextoWeb() {
		Set<String> contextHandles= getDriver().getContextHandles();
		for (String valor: contextHandles) {
			System.out.print(valor);			
		}
		
		getDriver().context((String)contextHandles.toArray()[1]);
		
		
	}
	
	public void setEmail(String email) {
		getDriver().findElement(By.id("email")).sendKeys(email);
	}
	
	public void setSenha(String senha) {
		getDriver().findElement(By.id("email")).sendKeys(senha);
	}

	/*public void sairContextoWeb() {
		getDriver().context((String)contextHandles.toArray()[0]);
	}*/
}
