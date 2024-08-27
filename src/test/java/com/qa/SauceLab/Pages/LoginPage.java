package com.qa.SauceLab.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement userNameField;
    @FindBy(css = "#password")
    WebElement passwordField;

    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(xpath = "//h3")
    WebElement textWhileWrongLogin;

    public void enterData(String userName, String password) throws InterruptedException {
        userNameField.sendKeys(userName, Keys.ENTER);
        Thread.sleep(1000);
        passwordField.sendKeys(password, Keys.ENTER);
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(1000);
    }
    public void wrongLogin(String userName, String password, String textWrongLogin) throws InterruptedException {
        userNameField.sendKeys(userName, Keys.ENTER);
        Thread.sleep(1000);
        passwordField.sendKeys(password, Keys.ENTER);
        Thread.sleep(1000);
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(textWhileWrongLogin), textWrongLogin);
    }
}
