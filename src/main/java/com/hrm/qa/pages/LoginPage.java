package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.BaseDetails;

public class LoginPage extends BaseDetails{
	
	//PageFactory or Object repository
	@FindBy(name = "txtUsername")
	WebElement username;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//*[@id='divLogo']/img")
	WebElement logoimg;

	
	@FindBy(xpath = "//*[@id=\"social-icons\"]/a[1]")
	WebElement linkedin;
	
	@FindBy(xpath = "//*[@id=\"social-icons\"]/a[2]")
	WebElement facebookele;
	
	@FindBy(xpath = "//*[@id=\"social-icons\"]/a[3]")
	WebElement twitterEle;
	
	@FindBy(xpath = "//*[@id=\"social-icons\"]/a[1]")
	WebElement youtubeEle;
	
	
	//All @FindBy element will get initailize with initElements method and this means current class object
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return logoimg.isDisplayed();
	}

	public DashBoardPage validateLogin(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new DashBoardPage();
	}
	
	public boolean validateSocialicon()
	{
		return youtubeEle.isDisplayed();
	}
}
