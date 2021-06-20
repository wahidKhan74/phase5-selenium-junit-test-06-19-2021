package com.ecom.webapp.facebook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin2Test {

	final String siteURL = "https://www.facebook.com/";
	final String driverPath = "driver/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteURL);
	}
	
	@AfterEach
	void cleanUp() {
		driver.close();
	}
	
	@Test
	void invalidUserCredsTest() throws InterruptedException {
		// actions
		driver.findElement(By.cssSelector("#email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("admin@123");
		driver.findElement(By.name("login")).submit();
		
		//delay
		Thread.sleep(10000);
		WebElement error = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
		assertEquals("Invalid username or password", error.getText());
		// test
	}
}
