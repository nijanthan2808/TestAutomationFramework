package com.example.framework.pages;

import com.example.framework.utils.Waits;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private final Duration timeout;

    public HomePage(WebDriver driver) {
        this(driver, Duration.ofSeconds(10));
    }

    public HomePage(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.timeout = timeout;
    }

    public String getHeadingText() {
        WebElement heading = Waits.visible(driver, HomePageLocators.HEADING, timeout);
        return heading.getText().trim();
    }
}
