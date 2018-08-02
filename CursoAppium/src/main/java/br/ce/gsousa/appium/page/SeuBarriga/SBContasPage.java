package br.ce.gsousa.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.BasePage;

public class SBContasPage extends BasePage {

	public void setConta(String nome) {
		escrever(By.className("android.widget.EditText"), nome);
	}
	
	public void salvar() {
		clicarTexto("SALVAR");
	}
	
	public void selecionarContas(String conta) {
		cliqueLongo(By.xpath("//*[@text='"+conta+"']"));	
	}
	
	public void excluir() {
		clicarTexto("EXCLUIR");
	}
}
