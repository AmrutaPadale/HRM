package com.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
	
	@Test 
	public void LaunchApp()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	
	@Test
	public void VerifyLandingDash()
	{
		Assert.assertTrue(driver.findElement(By.id("menu_dashboard_index")).isEnabled(), "Selected dashoard");
		//driver.findElement(By.xpath("//*[@id=\'dashboard__employeeDistribution\']")).isDisplayed();	
	}
	
	@Test
	public void VerifyClickInfoTab()
	{
		driver.findElement(By.xpath("//*[@id=\'menu_pim_viewMyDetails\']/b")).click();
		
		
	}


}
