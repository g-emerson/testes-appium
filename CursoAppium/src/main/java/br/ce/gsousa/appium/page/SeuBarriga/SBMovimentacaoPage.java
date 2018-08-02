package br.ce.gsousa.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;

public class SBMovimentacaoPage extends BasePage {

	public void salvar() {
		clicarTexto("SALVAR");
	}
	
	public void setDescricao(String descricao) {
		escrever(By.className("android.widget.EditText"), descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever(By.xpath("//android.widget.EditText[2]"), interessado);
	}
	
	public void setValor(String valor) {
		escrever(By.xpath("//android.widget.EditText[3]"), valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
	}
}
