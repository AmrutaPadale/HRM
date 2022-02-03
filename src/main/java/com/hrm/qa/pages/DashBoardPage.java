package com.hrm.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.BaseDetails;

public class DashBoardPage extends BaseDetails{
	
//	@FindBy(xpath="//*[@id='menu_leave_viewLeaveModule']/b)]")
//	WebElement leaveTab;
//	
//	@FindBy(xpath="//*[@id='menu_recruitment_viewRecruitmentModule']/b)]")
//	WebElement recruitmentTab;
//	
//	@FindBy(xpath="//*[@id='menu__Performance']/b)]")
//	WebElement performanceTab;
//	
	@FindBy(xpath="//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[1]/div/a/span")
	WebElement assign_Leave;
	
	@FindBy(xpath="//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[2]/div/a/span")
	WebElement leave_List;
	
	@FindBy(xpath="//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[3]/div/a/span")
	WebElement timesheets;
	
	@FindBy(xpath="//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a/span")
	WebElement apply_Leave;
	
	@FindBy(xpath="//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[5]/div/a/span")
	WebElement my_Leave;
	
	@FindBy(xpath="//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[6]/div/a/span")
	WebElement my_timesheet;
	
	@FindBy(xpath="//*[@id='content']/div/div[1]/h1")
	WebElement dashboard;
	
//	WebElement assignurl = driver.findElement(By.xpath(""));
//	
//	WebElement assign_leave_url =driver.findElement(By.xpath("//a[@href='/index.php/leave/assignLeave']"));
//	WebElement leave_List_url = driver.findElement(By.xpath("//a[@href='/index.php/leave/viewLeaveList']"));
//	WebElement timesheets_url =driver.findElement(By.xpath("//a[@href='/index.php/time/viewEmployeeTimesheet']"));
//	WebElement apply_Leave_url = driver.findElement(By.xpath("//a[@href='/index.php/leave/applyLeave']"));
//	WebElement my_Leave_url = driver.findElement(By.xpath("//a[@href='/index.php/leave/viewMyLeaveList']"));
//	WebElement my_timesheet_url = driver.findElement(By.xpath("//a[@href='/index.php/dashboard']"));
	
	@FindBy(xpath="//a[@href='/index.php/leave/assignLeave']//img[@src='/webres_61df95b840c401.55064388/orangehrmLeavePlugin/images/ApplyLeave.png']")
	WebElement assign_leave_img; 
	@FindBy(xpath="//a[@href='/index.php/leave/viewLeaveList']//img[@src='/webres_61df95b840c401.55064388/orangehrmLeavePlugin/images/MyLeave.png']")
	WebElement leave_List_img;
	@FindBy(xpath="//a[@href='/index.php/time/viewEmployeeTimesheet']//img[@src='/webres_61df95b840c401.55064388/orangehrmTimePlugin/images/MyTimesheet.png']")
	WebElement timesheets_img;
	@FindBy(xpath="//a[@href='/index.php/leave/applyLeave']//img[@src='/webres_61df95b840c401.55064388/orangehrmLeavePlugin/images/ApplyLeave.png']")
	WebElement apply_Leave_img;
	@FindBy(xpath="//a[@href='/index.php/leave/viewMyLeaveList']//img[@src='/webres_61df95b840c401.55064388/orangehrmLeavePlugin/images/MyLeave.png']")
	WebElement my_Leave_img;
	@FindBy(xpath="//a[@href='/index.php/dashboard']//img[@src='/webres_61df95b840c401.55064388/orangehrmTimePlugin/images/MyTimesheet.png']")
	WebElement my_timesheet_img;

	
	public DashBoardPage() {
		PageFactory.initElements(driver, this); 
		System.out.println("In constructor -initialization");
	}
	
//	public LeavePage validateLeaveTab()
//	{
//		leaveTab.click();
//		return new LeavePage();
//	}
//	
//	public RecruitmentPage validateRecruitmentTab()
//	{
//		recruitmentTab.click();
//		return new RecruitmentPage();
//	}
//	
//	public PerformancePage validatePerformanceTab()
//	{
//		performanceTab.click();
//		return new PerformancePage();
//	}
	
	public List<String> validateQuickLaunchValueList() {
		List<String> quickLaunchList =new ArrayList<String>();
		quickLaunchList.add(assign_Leave.getText());
		quickLaunchList.add(leave_List.getText());
		quickLaunchList.add(timesheets.getText());
		quickLaunchList.add(apply_Leave.getText());
		quickLaunchList.add(my_Leave.getText());
		quickLaunchList.add(my_timesheet.getText());
	
		return quickLaunchList;
	}
	
	public Map<String,String> validateQuickLaunchListImg() {
		Map<String,String> quickLaunchListactimg = new HashMap<String,String>();
		quickLaunchListactimg.put(assign_Leave.getText(), assign_leave_img.getAttribute("src").split("/")[6]);
		quickLaunchListactimg.put(leave_List.getText(), leave_List_img.getAttribute("src").split("/")[6]);
		quickLaunchListactimg.put(timesheets.getText(), timesheets_img.getAttribute("src").split("/")[6]);
		quickLaunchListactimg.put(apply_Leave.getText(), apply_Leave_img.getAttribute("src").split("/")[6]);
		quickLaunchListactimg.put(my_Leave.getText(), my_Leave_img.getAttribute("src").split("/")[6]);
		//quickLaunchListactimg.put(my_timesheet.getText(), my_timesheet_img.getText());
		
		return quickLaunchListactimg;
	}
	public boolean validateDashboardLabel() {
		return dashboard.isDisplayed();
	}

}
