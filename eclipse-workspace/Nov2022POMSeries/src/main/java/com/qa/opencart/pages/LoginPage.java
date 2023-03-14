package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1.maintain private By locators
	
	private By emailId=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value='Login']");
	private By forgotPwdLink=By.linkText("Forgotten Password");
	
	//page constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	//page actions
	public String getLoginPageTitle() {
		
		String title=eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT,AppConstants.LOGIN_PAGE_TITLE_VALUE);
		
		System.out.println("Login page title:"+title);
		return title;
	}
	public String getLoginPageURL() {
		
		String url=eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT,AppConstants.LOGIN_PAGE_URL_FRACTIONVALUE);
		System.out.println("page url is:"+url);
		return url;
	}
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
		
		//return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public AccountsPage doLogin(String un,String pwd) {
		
		System.out.println("App credentials are :"+ un + ":" + pwd);

		eleUtil.waitForElementVisible(emailId, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}

}
