package br.ce.gsousa.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	    
	  
	    driver.quit();
	}
}
