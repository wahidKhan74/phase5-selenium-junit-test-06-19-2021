package com.ecom.webapp.amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHompageTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/chromedriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteURL);
	}

	@Test
	void testAmazonHomePage() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
		
//		if (expectedTitle.contentEquals(driver.getTitle())) {
//			System.out.println("Test is passed !");
//		} else {
//			System.out.println("Test is failed !");
//		}
	}

	@Test
	void testSourceURL() {
		assertEquals(siteURL, driver.getCurrentUrl());
	}
	
	@AfterEach
	void cleanUp() {
		driver.close();
	}
}
