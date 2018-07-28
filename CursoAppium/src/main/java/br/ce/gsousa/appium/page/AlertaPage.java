package br.ce.gsousa.appium.page;

import br.ce.gsousa.appium.core.BasePage;

public class AlertaPage extends BasePage {
	
	public void clicarAlertaConfirm() {
		clicarTexto("ALERTA CONFIRM");
	}
	
	
	
	public void confirmar() {
		clicarTexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarTexto("SAIR");
	}
	
	public void clicarAlertaSimples() {
		clicarTexto("ALERTA SIMPLES");
	}
	
	public void clicarForaCaixa() {
		tap(100, 150);		
	}
	
}
