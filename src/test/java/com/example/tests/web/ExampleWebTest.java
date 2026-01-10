package com.example.tests.web;

import com.example.framework.core.BaseTest;
import com.example.framework.core.DriverFactory;
import com.example.framework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.SkipException;

public class ExampleWebTest extends BaseTest {

    @Test
    public void shouldLoadHomePage() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertEquals(homePage.getHeadingText(), "Example Domain");
    }

    @Test
    public void shouldFailExample() {
        Assert.fail("Intentional failure for Extent report demo.");
    }

    @Test
    public void shouldSkipExample() {
        throw new SkipException("Intentional skip for Extent report demo.");
    }

    @Test
    public void shouldHaveExpectedTitle() {
        String title = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(title, "Example Domain");
    }

    @Test
    public void shouldContainExampleText() {
        String pageSource = DriverFactory.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains("Example Domain"));
    }
}
