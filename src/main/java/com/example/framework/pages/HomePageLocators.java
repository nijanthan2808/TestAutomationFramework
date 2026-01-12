package com.example.framework.pages;

import org.openqa.selenium.By;

public final class HomePageLocators {
    public static final By HEADING = By.cssSelector("h1");
    public static final By FORMFIELDS = By.linkText("Form Fields");
    public static final By NAMEINPUT = By.id("name-input");
    public static final By PASSWORDINPUT = By.xpath("//*[@id='feedbackForm']/label[2]/input");
    public static final By DRINK3 = By.id("drink3");
    public static final By COLOR2 = By.id("color2");
    public static final By AUTOMATIONSELECT = By.id("automation");
    public static final By EMAILINPUT = By.id("email");
    public static final By MESSAGEINPUT = By.id("message");
    public static final By SUBMITBUTTON = By.id("submit-btn");
    

 
 
 
    private HomePageLocators() {
    }
}
