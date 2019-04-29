package com.orangeHrmLive.qa.pages;

import com.orangeHrmLive.qa.pages.enums.Country;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GeneralInformation extends OrganizationPage {

    @FindBy(id = "genInfoHeading")
    WebElement organizationPageHeader;

    @FindBy(id = "organization_country")
    WebElement country;
    @FindBy(id = "organization_street1")
    WebElement street1;
    @FindBy(id = "organization_street2")
    WebElement street2;
    @FindBy(id = "organization_city")
    WebElement city;
    @FindBy(id = "organization_province")
    WebElement state;
    @FindBy(id = "organization_zipCode")
    WebElement zip;
    @FindBy(id = "organization_phone")
    WebElement telephone;
    @FindBy(id = "organization_email")
    WebElement email;
    @FindBy(id = "btnSaveGenInfo")
    WebElement saveButton;


    public String getOrganizationPageHeader() {
        return organizationPageHeader.getText();
    }

    public GeneralInformation setCountry(Country countryName){
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText(countryName.getCountry());
        return this;
    }
    public GeneralInformation setStreet1(String streetName1){
        street1.sendKeys(streetName1);
        return this;
    }
    public GeneralInformation setStreet2(String streetName2){
        street2.sendKeys(streetName2);
        return this;
    }
    public GeneralInformation setCity(String cityName){
        city.sendKeys(cityName);
        return this;
    }
    public GeneralInformation setState(String stateName){
        state.sendKeys(stateName);
        return this;
    }
    public GeneralInformation setZipCode(String zipCode){
        city.sendKeys(zipCode);
        return this;
    }
    public GeneralInformation setTelephone(String telephone){
        state.sendKeys(telephone);
        return this;
    }
    public GeneralInformation setEmail(String email){
        city.sendKeys(email);
        return this;
    }
    public void saveEditButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", saveButton);
    }

}
