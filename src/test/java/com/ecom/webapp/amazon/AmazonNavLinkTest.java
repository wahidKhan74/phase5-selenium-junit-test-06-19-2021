package com.ecom.webapp.amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonNavLinkTest {

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
	@DisplayName("Amazon Test :  Mobile link verification")
	void testMobileLinkNavigation() {
		// find mobile
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		// test web element exist
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());
		// click
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());
	}

	@Test
	@DisplayName("Amazon Test :  Fashion link verification")
	void testFashionLinkNavigation() {
		WebElement fashinLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		// test web element exist
		assertTrue(fashinLink.isDisplayed());
		assertTrue(fashinLink.isEnabled());
		// click
		fashinLink.click();
		assertEquals("Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids", driver.getTitle());
	}

	
	// TODO: WAT for 3 nav links 
	
	
	@AfterEach
	void cleanUp() {
		driver.close();
	}
}
