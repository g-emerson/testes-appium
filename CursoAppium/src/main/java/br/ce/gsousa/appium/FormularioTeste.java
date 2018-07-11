package br.ce.gsousa.appium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.DSL;
import br.ce.gsousa.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {
	
	private AndroidDriver<MobileElement> driver ;
	private DSL dsl=  new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	    
	  //selecionar item formulario
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();	    
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}	
	
	@Test
	public  void devePreencherCampoTexto() throws MalformedURLException {
	    //escrever nome
	   dsl.escrever(MobileBy.AccessibilityId("nome"), "Gerry"); 
	    
	    //verificar nome escrito
	    assertEquals("Gerry", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}
	
	@Test
	public  void deveInteragirComCombo() throws MalformedURLException {
	    //clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		String texto = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		    Assert.assertEquals("Nintendo Switch", texto);
	}
	
	@Test
	public  void deveInteragirComSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
		//verificar status dos elementos
	   dsl.clicar(By.className("android.widget.CheckBox"));
	   dsl.clicar(MobileBy.AccessibilityId("switch"));
		   
	   //verificar status alterados
	   Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}
	
	@Test
	public  void deveRealizarrCadastro() throws MalformedURLException {
	    //Preenche nome, combo
		dsl.escrever(By.className("android.widget.EditText"), "Gerry");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"), "PS4");
		    
	    //clica no botao salvar android.widget.TextView
	    dsl.clicarTexto("SALVAR");
		 
	    //verifica cadastro nome console switch check box
	    assertEquals("Nome: Gerry", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]")));
	    assertEquals("Console: ps4", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]")));
	    assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]")).endsWith("Off"));
	    assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]")).endsWith("Marcado"));
		}
}
