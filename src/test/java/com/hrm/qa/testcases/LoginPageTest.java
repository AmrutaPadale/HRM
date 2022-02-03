package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.BaseDetails;
import com.hrm.qa.pages.DashBoardPage;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends BaseDetails{
	
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialiazation();
		loginpage =new LoginPage();
				
	}
	
	@Test(priority =1)
	public void verifyloginPageTitleTest()
	{
		loginpage.validateLoginPageTitle();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=2)
	public void verifyHRMLogoTest() {
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyLoginTest() {
		dashBoardPage = loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
