package com.orangeHrmLive.qa;

import com.orangeHrmLive.qa.base.TestBase;
import com.orangeHrmLive.qa.pages.GeneralInformation;
import com.orangeHrmLive.qa.pages.HomePage;
import com.orangeHrmLive.qa.pages.LoginPage;
import com.orangeHrmLive.qa.pages.enums.Country;
import com.orangeHrmLive.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHrmLiveTest extends TestBase {

    private LoginPage loginPage;
    private HomePage homePage;

//    public OrangeHrmLiveTest(){
//        super();
//    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData("TestSheetName");
        return data;
    }

    @BeforeClass
    public void beforeTest() {
        initialization();
        homePage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test (priority = 1)
    public void loginTest() {
        Assert.assertEquals(homePage.getLoggedInUser(), "Welcome Admin");
        Assert.assertEquals(homePage.getHomePageTitle(), "OrangeHRM");
        Assert.assertEquals(homePage.getHomePageUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }


    @Test(priority = 2)
    public void generalInformationTest() {
        GeneralInformation generalInformation = homePage.selectAdminTab().selectOrganization().selectGeneralInformation();
        Assert.assertEquals(generalInformation.getOrganizationPageHeader(), "General Information");
        generalInformation.saveEditButton();
        generalInformation.setCountry(Country.UNITED_KINGDOM);
        generalInformation.setStreet1("538 Teal Plaza_test");
        generalInformation.setStreet2("test");
        generalInformation.setCity("Secaucus_test");
        generalInformation.setState("NJ_test");
        generalInformation.setZipCode("560076");
        generalInformation.setTelephone("0987654321");
        generalInformation.setEmail("test@test.com");
        generalInformation.saveEditButton();
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
