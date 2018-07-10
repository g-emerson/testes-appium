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
	public  void deveInstalarAPK() throws MalformedURLException {
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
}
