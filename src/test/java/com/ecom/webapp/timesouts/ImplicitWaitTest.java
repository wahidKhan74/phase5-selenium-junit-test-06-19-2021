package com.ecom.webapp.timesouts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitTest {
	
	final String siteURL = "https://www.facebook.com/";
	final String driverPath = "driver/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// implicit timeouts
		// The implicit in selenium is used for tell the web driver to wait for 
		// a certain time before it throw a "No Such element exception" default implicit setting is 0.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.get(siteURL);
	}
	
	@AfterEach
	void cleanUp() {
		driver.close();
	}
	
	
	@Test
	void invalidUserCredsTest() {
		// actions
		driver.findElement(By.id("email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("admin@123");
		driver.findElement(By.name("login")).submit();
		
		WebElement error = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
		assertEquals("Invalid username or password", error.getText());
	}
}
