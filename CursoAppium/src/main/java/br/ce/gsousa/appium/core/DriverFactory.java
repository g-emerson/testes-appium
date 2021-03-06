package br.ce.gsousa.appium.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			// createDrive();
			createTestObjectDrive();
		}
		return driver;
	}

	private static void createDrive() {
		try {
			String apkCaminho = new File("../CursoAppium/src/main/resources/CTAppium-1-1.apk").getCanonicalPath();

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "emulator-5554");
			desiredCapabilities.setCapability("automationName", "uiAutomator2");
			desiredCapabilities.setCapability(MobileCapabilityType.APP, apkCaminho);

			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void createTestObjectDrive() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("testobject_api_key", "B5B0F35D95494712997B4EA2A1DADC4A");
		desiredCapabilities.setCapability("appiumVersion", "1.7.2");
		desiredCapabilities.setCapability("language", "pt");
		desiredCapabilities.setCapability("automationName", "uiAutomator2");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("https://eu1.appium.testobject.com/wd/hub"),
					desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
