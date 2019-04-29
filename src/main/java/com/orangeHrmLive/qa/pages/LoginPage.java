package com.orangeHrmLive.qa.pages;

import com.orangeHrmLive.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase {

	@FindBy(id="txtUsername")
	WebElement username;

	@FindBy(name="txtPassword")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;


	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
}
