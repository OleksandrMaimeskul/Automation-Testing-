package com.qa.bank.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class BankLoginPage {
    private final WebDriver driver;
    /*
    1. Under page class we store our Constructor
    2. Find the Elements and store as a WebElement with @FindBy annotation
    3. create methods with the WebElements and manipulations
     */

    public BankLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);  // driver.findElements(By....)
    }

//    WebElement header = driver.findElement(By.tagName("//strong"));

    @FindBy(tagName = "strong")
    WebElement header;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;

    @FindBy(xpath = "//button[@ng-click='manager()']")
    WebElement managerLoginButton;


    public void checkLoginPageInformation(WebDriver driver,String expectedHeader,String expectedUrl){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertTrue(customerLoginButton.isDisplayed() && customerLoginButton.isEnabled());
        Assert.assertTrue(managerLoginButton.isDisplayed() && managerLoginButton.isEnabled());
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    public void clickManagerLoginButton(){
        managerLoginButton.click();

    }

    public void clickHomeButton(){
        homeButton.click();
    }

    public void clickCustomerLoginButton(){
        customerLoginButton.click();
    }



}