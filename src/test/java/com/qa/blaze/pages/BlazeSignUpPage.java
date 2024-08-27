package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BlazeSignUpPage {
    public BlazeSignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sign-username")
    WebElement userName;

    @FindBy(id = "sign-password")
    WebElement password;

    @FindBy(xpath = "//button[@onclick='register()']")
    WebElement singUpButton2;

    public void signUpFunctionality(WebDriver driver, String userName, String password, String expectedMessage) throws InterruptedException {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        singUpButton2.click();
        Thread.sleep(3000);
        Alert alert =driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(), expectedMessage);
        alert.accept();
        Thread.sleep(3000);

    }


}
