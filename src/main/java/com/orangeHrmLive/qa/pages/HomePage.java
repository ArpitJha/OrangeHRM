package com.orangeHrmLive.qa.pages;

import com.orangeHrmLive.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	@FindBy(id = "welcome")
	WebElement welcomeUser;

	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement adminTab;

	@FindBy(id = "menu_admin_Organization")
	WebElement organizationTab;


	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}

	public String getHomePageUrl() {
		return driver.getCurrentUrl();
	}

	public String getLoggedInUser() {
		return welcomeUser.getText();
	}
	public AdminPage selectAdminTab(){
        action.moveToElement(adminTab).build().perform();
        return new AdminPage();
	}

}