package br.ce.gsousa.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.gsousa.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {
	
	private AndroidDriver<MobileElement> driver ;
	
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
	   MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Gerry");
	    
	    //verificar nome escrito
	    String texto = campoNome.getText();
	    Assert.assertEquals("Gerry", texto);
	}
	
	@Test
	public  void deveInteragirComCombo() throws MalformedURLException {
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	   
	   	//selecionar opcao desejada Nitendo Switch
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //verificar nome escrito 
	    String texto = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    
	    //String texto = campoNome.getText();
	    Assert.assertEquals("Nintendo Switch", texto);
	}
	
	@Test
	public  void deveInteragirComSwitchCheckBox() throws MalformedURLException {
	   //verificar status dos elementos
	   MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	   MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	   Assert.assertTrue(check.getAttribute("checked").equals("false"));
	   Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	   
	    //clicar nos elementos
	   check.click();
	   switc.click();
	   
	    //verificar status alterados
	   Assert.assertFalse(check.getAttribute("checked").equals("false"));
	   Assert.assertFalse(switc.getAttribute("checked").equals("true"));
	}
	
	@Test
	public  void devePrencherCadastroCompleto() throws MalformedURLException {
	    //Preenche nome, combo
	    driver.findElement(By.className("android.widget.EditText")).sendKeys("Gerry");
	    driver.findElement(By.className("android.widget.CheckBox")).click();
	    driver.findElement(By.className("android.widget.Switch")).click();
	    driver.findElement(By.className("android.widget.Spinner")).click();
	  	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
	 	    
	    //clica no botao salvar android.widget.TextView
	    driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
	    
	    //verifica cadastro nome console switch check box
	   
	    MobileElement nome =  driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));
	    Assert.assertEquals("Nome: Gerry", nome.getText());
	    
	    MobileElement console = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]"));
	    Assert.assertEquals("Console: ps4", console.getText());
	    
	    MobileElement switc = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));
	    Assert.assertTrue(switc.getText().endsWith("Off"));
	    
	    MobileElement checkbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"));
	    Assert.assertTrue(checkbox.getText().endsWith("Marcado"));
		}
}
