package br.ce.gsousa.appium.page;

import br.ce.gsousa.appium.core.DSL;

public class MenuPage {

	private DSL dsl=  new DSL();
	
	public void	 acessarFormulario() {
	    dsl.clicarTexto("Formulário");
	}
}
