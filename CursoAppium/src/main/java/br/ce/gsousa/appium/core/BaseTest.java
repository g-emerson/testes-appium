package br.ce.gsousa.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();
	
	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		gerarScreenShot();
		DriverFactory.getDriver().resetApp();
	}
	
	public void gerarScreenShot() {
		try {
			File imagem = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem,new File("target/screenShots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperar(long segundos) {
		try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
}
