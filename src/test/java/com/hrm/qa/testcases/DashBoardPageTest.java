package com.hrm.qa.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.BaseDetails;
import com.hrm.qa.pages.DashBoardPage;
import com.hrm.qa.pages.LoginPage;

public class DashBoardPageTest extends BaseDetails{
	DashBoardPage dashBoardPage;
	LoginPage loginPage ;
	
	public DashBoardPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialiazation();
		loginPage = new LoginPage();
		dashBoardPage =new DashBoardPage();
		dashBoardPage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test
//	public void verifyDashboardLabel() {
//		dashBoardPage.validateDashboardLabel();
//	}
	
//	@Test
//	public void VerifyRecruitementTab() {
//		dashBoardPage.validateLeaveTab();
//	}
	
	@Test(priority=3)
	public void verifyQuickLaunchListValueTest() {		
		List<String> quickLaunchListActual = new ArrayList<String>();

		quickLaunchListActual.add("Assign Leave");
		quickLaunchListActual.add("Leave List");
		quickLaunchListActual.add("Timesheets");
		quickLaunchListActual.add("Apply Leave");
		quickLaunchListActual.add("My Leave");
		quickLaunchListActual.add("My Timesheet");
	
		Assert.assertEquals(dashBoardPage.validateQuickLaunchValueList(),quickLaunchListActual );
	}
	
	@Test(priority=3)
	public void verifyQuickLaunchListImgTest() {
		Map<String,String> quickLaunchListExpimg = new HashMap<String,String>();
		//quickLaunchListExpimg.put("Assign Leave", "ApplyLeave.png");
		quickLaunchListExpimg.put("Leave List", "MyLeave.png");
		quickLaunchListExpimg.put("Timesheets", "MyTimesheet.png");
		quickLaunchListExpimg.put("Apply Leave", "ApplyLeave.png");
		quickLaunchListExpimg.put("My Leave", "MyLeave.png");
		//quickLaunchListExpimg.put("My Timesheet", "/webres_61df95b840c401.55064388/orangehrmTimePlugin/images/MyTimesheet.png");	
		
		Assert.assertEquals(dashBoardPage.validateQuickLaunchListImg(),quickLaunchListExpimg );
	}
	
	@AfterMethod
	public void trash()
	{
		driver.quit();
	}
	

}
