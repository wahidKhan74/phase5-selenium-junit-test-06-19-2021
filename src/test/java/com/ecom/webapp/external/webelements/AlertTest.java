package com.ecom.webapp.external.webelements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTest {
	
	final String siteURL = "file:///home/wahidkhan74gmai/PG2Workspace/phase5-selenium-junit-test-06-19-2021/static/external-web-alerts.html";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}
	
	@AfterEach
	void cleanUp() {
		driver.close();
	}
	
	@Test
	@DisplayName("Alert Test : Java Script alert window")
	void testAlertDailogWindow() throws InterruptedException {
		
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(2) > button"));
		alertButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		Assertions.assertEquals("Are you sure !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirmation Alert Test : Java Script confirmation alert window with accpet")
	void testConfirmationDailogWindowWithAccept() throws InterruptedException {
		
		WebElement confirmationButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmationButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		Assertions.assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		//click on ok
		alert.accept();
	}
	
	@Test
	@DisplayName("Confirmation Alert Test : Java Script confirmation alert window with dismis")
	void testConfirmationDailogWindowWithDismiss() throws InterruptedException {
		
		WebElement confirmationButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmationButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		Assertions.assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		//click on cancel
		alert.dismiss();
	}
	
	
	@Test
	@DisplayName("Prompt Alert Test : Java Script confirmation alert window with dismis")
	void testPromptDailogWindowWithAccepts() throws InterruptedException {
		
		WebElement promptButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		promptButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		Assertions.assertEquals("Please enter your name", alert.getText());
		alert.sendKeys("Tony stark");
		Thread.sleep(3000);
		//click on cancel
		alert.accept();
	}
	
}
