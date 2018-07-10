package br.ce.gsousa.appium;

import static org.junit.Assert.assertArrayEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class FormularioTeste {
	
	@Test
	public  void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Treinamento\\testes-appium\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    //desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //selecionar formulario
	   List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	   elementosEncontrados.get(1).click();
	   
	    //escrever nome
	   MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Gerry");
	    
	    //verificar nome escrito
	    String texto = campoNome.getText();
	    Assert.assertEquals("Gerry", texto);
	  
	    driver.quit();
	}
	
	@Test
	public  void deveInteragirComCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Treinamento\\testes-appium\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    //desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //selecionar formulario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	   
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	   
	   	//selecionar opcao desejada Nitendo Switch
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    //verificar nome escrito 
	    String texto = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    
	    //String texto = campoNome.getText();
	    Assert.assertEquals("Nintendo Switch", texto);
	  
	    driver.quit();
	}
	
	@Test
	public  void deveInteragirComSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Treinamento\\testes-appium\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    //desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //selecionar formulario
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	   
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
	  
	    driver.quit();
	}
	
	@Test
	public  void devePrencherCadastroCompleto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\Treinamento\\testes-appium\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");
	    //desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    //selecionar item formulario
	    List<MobileElement> listaElementos = driver.findElements(By.className("android.widget.TextView"));
	    listaElementos.get(1).click();
	    
	    //Preenche nome
	   MobileElement campoNome =  driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Gerry");
	    //seleciona combobox
	   MobileElement combo=  driver.findElement(By.className("android.widget.Spinner"));
	    combo.click();
	    
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
	    //maarca checkbox
	    driver.findElement(MobileBy.AccessibilityId("check")).click();
	    
	    //arrasta switch
	    driver.findElement(MobileBy.AccessibilityId("switch")).click();
	    
	    //clica no botao salvar android.widget.TextView
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	    
	    //verifica cadastro nome console switch check box
	   String nome =  driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Gerry']")).getText();
	   String console = driver.findElement(By.xpath("//android.widget.TextView[@text='Console: ps4']")).getText();
	   String switc = driver.findElement(By.xpath("//android.widget.TextView[@text='Switch: Off']")).getText();
	   String checkbox = driver.findElement(By.xpath("//android.widget.TextView[@text='Checkbox: Marcado']")).getText();
	    
	    
	    
	Assert.assertEquals("Nome: Gerry", nome);
	Assert.assertEquals("Console: ps4", console);
	Assert.assertEquals("Switch: Off", switc);
	Assert.assertEquals("Checkbox: Marcado", checkbox);
	
	
	
	}
}
