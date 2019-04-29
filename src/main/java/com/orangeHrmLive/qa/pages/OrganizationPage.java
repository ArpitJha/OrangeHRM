package com.orangeHrmLive.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage extends AdminPage {

    @FindBy(id = "menu_admin_viewOrganizationGeneralInformation")
    WebElement generalInformation;

    public GeneralInformation selectGeneralInformation() {
        action.moveToElement(generalInformation).build().perform();
        generalInformation.click();
        return new GeneralInformation();
    }
}
