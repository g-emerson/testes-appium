package br.ce.gsousa.appium.page;

import br.ce.gsousa.appium.core.BasePage;

public class MenuPage extends BasePage{
	
	public void	 acessarFormulario() {
	    clicarTexto("Formulário");
	}
	
	public void	 acessarSplash() {
	    clicarTexto("Splash");
	}
	
	public void	 acessarAlertas() {
	    clicarTexto("Alertas");
	}
}
