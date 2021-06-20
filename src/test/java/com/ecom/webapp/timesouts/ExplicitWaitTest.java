package com.ecom.webapp.timesouts;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {
	
	final String siteURL = "https://www.facebook.com/";
	final String driverPath = "driver/chromedriver";
	WebDriver driver;
	WebDriverWait wait;
	

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// explicit wait : explicit wait is used to tell the web driver to wait for a certain condition 
		// or maximum time to be exceeded before throwing " Element Not Visible exception"		
		wait = new WebDriverWait(driver, 10);
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
		// normal way of finding element.
		// WebElement error = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
		
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div:nth-child(2)")));
		
		assertEquals("Invalid username or password", error.getText());
	}
}
