package com.ecom.webapp.amazon;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductSearchTest {
	
	final String siteURL = "https://www.amazon.in/";
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
	@DisplayName("Amazon Test : Search Product iphone 12 pro max+")
	void  testforSearchProductIphone12() {
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		assertTrue(searchBox.isDisplayed());
		assertTrue(searchBox.isEnabled());
		
		searchBox.sendKeys("iphone 12 pro max+");
		searchBox.submit();
	}
	
	
	@Test
	@DisplayName("Amazon Test : Search Product iphone 11 pro")
	void  testforSearchProductIphone11() {
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		assertTrue(searchBox.isDisplayed());
		assertTrue(searchBox.isEnabled());
		
		searchBox.sendKeys("iphone 11 pro");
		searchBox.submit();
	}
	
	
	// TODO : WAT for 3 more product search.
}
