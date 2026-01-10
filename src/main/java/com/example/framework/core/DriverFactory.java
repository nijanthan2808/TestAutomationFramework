package com.example.framework.core;

import com.example.framework.config.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void createDriver() {
        if (DRIVER.get() != null) {
            return;
        }
        String browser = ConfigLoader.getOrDefault("browser", "chrome").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigLoader.getOrDefault("headless", "false"));

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                if (headless) {
                    ffOptions.addArguments("-headless");
                }
                DRIVER.set(new FirefoxDriver(ffOptions));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }
                DRIVER.set(new EdgeDriver(edgeOptions));
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                chromeOptions.addArguments("--window-size=1280,800");
                DRIVER.set(new ChromeDriver(chromeOptions));
                break;
        }
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
