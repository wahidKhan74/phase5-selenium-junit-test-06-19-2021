package com.ecom.webapp.external.webelements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserWindowPopupTest {
	
	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(siteURL);
	}
	
	@AfterEach
	void cleanUp() {
		driver.close();
	}
	
	@Test
	void testForLocationPopup() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		// switch from main screen to popup screen
		String mainWindow = driver.getWindowHandle();
		
		// 2. sub windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			String childWindow = itr.next();
			
			// switch to child window
			driver.switchTo().window(childWindow);
			
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("400021");
			Thread.sleep(3000);
			
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
			
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
	}
}
