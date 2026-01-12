package com.example.framework.core;

import com.example.framework.config.ConfigLoader;
import com.example.framework.reporting.TestLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.createDriver();
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        String baseUrl = ConfigLoader.getOrDefault("web.baseUrl", "https://example.com");
        driver.get(baseUrl);
        TestLogger.info("Open base URL: " + baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
