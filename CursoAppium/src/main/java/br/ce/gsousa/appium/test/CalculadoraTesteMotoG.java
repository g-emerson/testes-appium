package br.ce.gsousa.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class CalculadoraTesteMotoG {
	
	@Test
	public  void deveSomarDoisValoress() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "0030260344");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.CalculatorGoogle");
	    	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    	    
	    MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
	    el1.click();
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("mais");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result");
	    
	    Assert.assertEquals("8", el4.getText());
	    driver.quit();
	}
}
