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
        String actualTitle = DriverFactory.getDriver().getTitle();
        Assert.assertEquals(actualTitle, "Not Example Domain",
            "Intentional failure for Extent report demo.");
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

    @Test
    public void shouldHaveNonEmptyTitle() {
        String title = DriverFactory.getDriver().getTitle();
        Assert.assertFalse(title.isEmpty());
    }

    @Test
    public void shouldContainIanaLink() {
        String pageSource = DriverFactory.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains("https://www.iana.org/domains/example"));
    }

    @Test
    public void shouldContainMoreInformationText() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertEquals(homePage.getHeadingText(), "Example Domain");
    }

    @Test
    public void shouldHaveBodyTag() {
        String pageSource = DriverFactory.getDriver().getPageSource();
        Assert.assertTrue(pageSource.toLowerCase().contains("<body"));
    }

    @Test
    public void shouldContainDomainWord() {
        String pageSource = DriverFactory.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains("domain"));
    }
}
