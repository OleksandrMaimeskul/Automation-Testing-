package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import javax.swing.*;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    WebElement logInButton2;

    @FindBy(css = "#loginusername")
    WebElement userName;

    @FindBy(css = "#nameofuser")
    WebElement welcomeHeader;

    public void logInFunctionality(String username, String password, String expectedMessage) throws InterruptedException {
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        logInButton2.click();
        Thread.sleep(3000);
        Assert.assertTrue(BrowserUtils.getText(welcomeHeader).contains(expectedMessage)&& welcomeHeader.isDisplayed());

    }
}
