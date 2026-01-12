package com.example.framework.pages;

import com.example.framework.reporting.TestLogger;
import com.example.framework.utils.Waits;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


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
        String text = heading.getText().trim();
        TestLogger.info("Read heading text: " + text);
        return text;
    }

    public HomePage clickFormFields(){
        TestLogger.info("Click Form Fields");
        WebElement formFields = Waits.clickable(driver, HomePageLocators.FORMFIELDS, timeout);
        formFields.click();
        return new HomePage(driver);
    }

    public void enterName(String name){
        TestLogger.info("Enter name");
        WebElement nameInput = Waits.visible(driver, HomePageLocators.NAMEINPUT, timeout);
        nameInput.sendKeys(name);
    }

    public void enterPassword(String password){
        TestLogger.info("Enter password");
        WebElement passwordInput = Waits.visible(driver, HomePageLocators.PASSWORDINPUT, timeout);
        passwordInput.sendKeys(password);
    }

    public void selectFavouriteDrink(){
        TestLogger.info("Select favourite drink");
        WebElement drink3 = Waits.clickable(driver, HomePageLocators.DRINK3, timeout);
        drink3.click();
    }

    public void selectFavouriteColor(){
        TestLogger.info("Select favourite color");
        Actions actions = new Actions(driver);
        WebElement color2 = Waits.clickable(driver, HomePageLocators.COLOR2, timeout);
        actions.moveToElement(color2).click().build().perform();
    } 

    public void selectAutomationDropDown(String option){
        TestLogger.info("Select automation dropdown: " + option);
        WebElement automationDropDown = Waits.clickable(driver, HomePageLocators.AUTOMATIONSELECT, timeout);
        Select select = new Select(automationDropDown);
        select.selectByVisibleText(option);
    }

    public void enterEmail(String email){
        TestLogger.info("Enter email");
        WebElement emailField = Waits.visible(driver, HomePageLocators.EMAILINPUT, timeout);
        emailField.sendKeys(email);
    }

    public void enterMessage(String message){
        TestLogger.info("Enter message");
        WebElement messageField = Waits.visible(driver, HomePageLocators.MESSAGEINPUT, timeout);
        messageField.sendKeys(message);
    }

    public void clickSubmit(){

        TestLogger.info("Click submit");
        Actions actions = new Actions(driver);
        WebElement submitButton = Waits.clickable(driver, HomePageLocators.SUBMITBUTTON, timeout);
        actions.moveToElement(submitButton).click().build().perform();
    }

    public boolean verifyAlertText(String alertText){
        String text = driver.switchTo().alert().getText();
        boolean matches = text.contains(alertText);
        TestLogger.info("Verify alert text contains: " + alertText + " (actual: " + text + ")");
        return matches;
    }

    public void acceptAlert(){
        TestLogger.info("Accept alert");
        driver.switchTo().alert().accept();
    }

}
