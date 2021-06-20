package com.ecom.webapp.webelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsTest {
	
	final String siteURL = "file:///home/wahidkhan74gmai/PG2Workspace/phase5-selenium-junit-test-06-19-2021/static/webelements.html";
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
	void testToVerifyRadioButtonExist() {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		assertEquals(false, radio2.isSelected());
		
		
		WebElement radio3 = driver.findElement(By.id("other"));
		assertEquals(true, radio3.isDisplayed());
		assertEquals(true, radio3.isEnabled());
		assertEquals(false, radio3.isSelected());
	}
	
	@Test
	void testToVerifyRadioButtonClick() throws InterruptedException {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		
		// click radio button
		radio1.click();
		Thread.sleep(2000);
		assertEquals(true, radio1.isSelected());
	}
	
	@Test
	void testToVerifyRadioButto2Click() throws InterruptedException {
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		
		// click radio button
		radio2.click();
		Thread.sleep(2000);
		assertEquals(true, radio2.isSelected());
	}
}
