package com.example.tests.web;

import com.example.framework.core.BaseTest;
import com.example.framework.core.DriverFactory;
import com.example.framework.pages.HomePage;
import com.example.framework.reporting.TestLogger;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.SkipException;
import java.lang.Thread;

public class ExampleWebTest extends BaseTest {

    @Test
    public void verifyTitleTest() {
        TestLogger.info("Verify page title contains expected text");
        String title = DriverFactory.getDriver().getPageSource();
        Assert.assertTrue(title.contains("Learn and Practice Automation | automateNow"));
    }

    @Test
    public void formFieldsTest() throws InterruptedException{
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        homePage.clickFormFields();
        TestLogger.info("Verify Form Fields heading");
        Assert.assertEquals(homePage.getHeadingText(),"Form Fields");
        homePage.enterName("Niju");
        homePage.enterPassword("niju123");
        homePage.selectFavouriteDrink();
        homePage.selectFavouriteColor();
        homePage.selectAutomationDropDown("Yes");
        homePage.enterEmail("niju@test.com");
        homePage.enterMessage("Test");
        homePage.clickSubmit();
        TestLogger.info("Verify alert and accept");
        homePage.verifyAlertText("Message received!");
        homePage.acceptAlert();
        
    }
}
