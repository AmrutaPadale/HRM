package com.Tests;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	@Test 
	public void TestGoogle() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.uk");
		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("HYR tutorials", Keys.ENTER);
		Thread.sleep(5000);
		String expectedTitle = "HYR tutorials - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle , "Result is failed title not match");
		driver.quit();		
	}

	@Test
	public void TestFacebook() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//button[@title=\'Allow All Cookies\']")).click();
		
		SoftAssert softassert = new SoftAssert();
		
		//Verify title
		String expectedTitle = "Eacebook - log in or sign up";
		String actualTitle = driver.getTitle();
		softassert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
		
		
		//verify url changes on adding username
		String expectedUrl = "https://www.facebook.com";
		String actualUrl = driver.getCurrentUrl();
		softassert.assertNotEquals(actualUrl, expectedUrl, "Url mismatch");
		
		//verify entering the username changes null
		//driver.findElement(By.name("email")).sendKeys("amruta369@gmail.co",Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String expectedUsername = " ";
		String actualUsername = driver.findElement(By.name("email")).getAttribute("Value");
		softassert.assertEquals(actualUsername, expectedUsername, "username mismatch");
		
		//verify bold red box on incorrect username
		String expectedBorder = "1px solid rgb(15, 2, 132)";
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		softassert.assertEquals(actualBorder, expectedBorder, "border mismatch");
		
		//verify the validation message
		String expectedErrorMsg = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualErrorMsg = driver.findElement(By.xpath("//div[@id=\'email_container\']/div[@class='_9ay7']/text()")).getText();
		softassert.assertEquals(actualErrorMsg, expectedErrorMsg, "Validation mismatch");
		
		driver.quit();
		softassert.assertAll();
	}

}
