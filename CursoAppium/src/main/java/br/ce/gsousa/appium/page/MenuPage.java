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
	
	public void	 acessarAbas() {
	    clicarTexto("Abas");
	}
	
	public void	 acessarAccordion() {
	    clicarTexto("Accordion");
	}
	
	public void	 acessarCliques() {
	    clicarTexto("Cliques");
	}
	
	public void	 acessarSwipe() {
		clicarTexto("Swipe");
	}

	public void acessarSwipeList() {
		clicarTexto("Swipe List");		
	}

}
