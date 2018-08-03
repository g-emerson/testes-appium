package br.ce.gsousa.appium.page.SeuBarriga;

import br.ce.gsousa.appium.core.BasePage;

public class SBMenuPage extends BasePage {

	public void acessarContas() {
		clicarTexto("CONTAS");
	}
	
	public void acessarMovimentacoes() {
		clicarTexto("MOV...");
	}
	
	public void acessarResumo() {
		clicarTexto("RESUMO");
	}
	
	public void acessarHome() {
		clicarTexto("HOME");
	}
}
