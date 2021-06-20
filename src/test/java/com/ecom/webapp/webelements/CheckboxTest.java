package com.ecom.webapp.webelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxTest {
	
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
	void testToVerifyExistExist() {
		
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
		
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		//default check / select
		assertEquals(true, checkBox2.isSelected());
		
		
		WebElement checkBox3 = driver.findElement(By.id("vehicle3"));
		assertEquals(true, checkBox3.isDisplayed());
		assertEquals(true, checkBox3.isEnabled());
		assertEquals(false, checkBox3.isSelected());
	}
	
	@Test
	void testToVerifyCheckboxClick() throws InterruptedException {
		
		WebElement vehicle1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, vehicle1.isDisplayed());
		assertEquals(true, vehicle1.isEnabled());
		
		// click radio button
		vehicle1.click();
		Thread.sleep(2000);
		assertEquals(true, vehicle1.isSelected());
	}
	
	@Test
	void testToVerifyCheckBox2Click() throws InterruptedException {
		
		WebElement vehicle2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, vehicle2.isDisplayed());
		assertEquals(true, vehicle2.isEnabled());
		
		// click radio button
		vehicle2.click();
		Thread.sleep(2000);
		assertEquals(false, vehicle2.isSelected());
	}
}
