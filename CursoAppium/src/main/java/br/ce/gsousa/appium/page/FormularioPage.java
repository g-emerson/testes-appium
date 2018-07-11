package br.ce.gsousa.appium.page;

import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {
	private DSL dsl=  new DSL();
	
	public void escreverNome(String nome) {
		dsl.escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		dsl.clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return dsl.isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void salvar() {
		dsl.clicarTexto("SALVAR");		
	}
	
	public String obterNomeCadastrato() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
	}
	
	public String obterConsoleCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]"));
	}
	
	public String obterCheckCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));
	}
	
	public String obterSwithCadastrado() {
		return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"));
	}
	
	
	
	
	
	
	
}
