package com.orangeHrmLive.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends HomePage {

    @FindBy(id = "menu_admin_Organization")
    WebElement organization;

    public OrganizationPage selectOrganization(){
        action.moveToElement(organization).build().perform();
        return new OrganizationPage();
    }


}
