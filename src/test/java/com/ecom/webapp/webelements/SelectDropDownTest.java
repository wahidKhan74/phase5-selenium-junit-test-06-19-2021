package com.ecom.webapp.webelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownTest {
	
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
	@DisplayName("Test: To veify select dropdown exist within form")
	void testToVerifySelectDropDownExist() {
		WebElement select = driver.findElement(By.id("vehicle"));
		assertEquals(true, select.isDisplayed());
		assertEquals(true, select.isEnabled());
	}
	
	@Test
	@DisplayName("Test: To veify first select dropdown option")
	void testToVerifyFirstSelecption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));		
		Select vSelect = new Select(select);
		
		// select a first option
		vSelect.selectByVisibleText("Bike");
		
		WebElement selectedOption = vSelect.getFirstSelectedOption();
		
		assertEquals(" Bike ", selectedOption.getText());
		
		Thread.sleep(2000);
		
	}
	
	
	@Test
	@DisplayName("Test: To veify 'Train' select dropdown option")
	void testToVerifyTrainSelecption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));		
		Select vSelect = new Select(select);
		
		// select a first option
		vSelect.selectByVisibleText("Train");
		
		WebElement selectedOption = vSelect.getFirstSelectedOption();
		
		assertEquals(" Train ", selectedOption.getText());
		
		Thread.sleep(2000);
		
	}
	
	@Test
	@DisplayName("Test: To veify select option based on index.")
	void testToVerifyIndexnSelecption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));		
		Select vSelect = new Select(select);
		
		// select a index option
		vSelect.selectByIndex(3);
		
		WebElement selectedOption = vSelect.getFirstSelectedOption();
		
		assertEquals(" Airplane ", selectedOption.getText());
		
		Thread.sleep(2000);
		
	}
	
	
	@Test
	@DisplayName("Test: To veify select option based on value.")
	void testToVerifyValueSelecption() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));		
		Select vSelect = new Select(select);
		
		// select a value select option
		vSelect.selectByValue("car");
		
		WebElement selectedOption = vSelect.getFirstSelectedOption();
		
		assertEquals(" Car ", selectedOption.getText());
		
		Thread.sleep(2000);
		
	}
}
