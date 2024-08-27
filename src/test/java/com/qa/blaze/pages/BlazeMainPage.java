package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeMainPage {

    public BlazeMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='navbar-collapse']//a[@data-target='#signInModal']")
    WebElement signUpButton;

    @FindBy(id = "login2")
    WebElement logInButton;

    public void signUpButton() {
        signUpButton.click();
    }

    public  void loginButton(){
        logInButton.click();
    }
}


