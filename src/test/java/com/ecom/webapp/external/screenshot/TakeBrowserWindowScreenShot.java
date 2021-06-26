package com.ecom.webapp.external.screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeBrowserWindowScreenShot {
	
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
	void testHomepageScreenShot() throws IOException {
		
		// type cast driver object to screen shot object 
		TakesScreenshot tsc =  (TakesScreenshot) driver;
		
		// take screen shot
		File scr = tsc.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(scr, new File("/home/wahidkhan74gmai/upload/amazon-home.png"));
		
	}
	@Test
	void testMobilepageScreenShot() throws IOException {
		
		driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();
		
		// type cast driver object to screen shot object 
		TakesScreenshot tsc =  (TakesScreenshot) driver;
		
		// take screen shot
		File scr = tsc.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(scr, new File("/home/wahidkhan74gmai/upload/amazon-mobile-page.png"));
		
	}
}
