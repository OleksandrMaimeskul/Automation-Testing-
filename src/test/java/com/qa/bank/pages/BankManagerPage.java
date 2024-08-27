package com.qa.bank.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    /*
    1-Click BankManagerLoginButton(create a method under LoginPage to click)
    2-Create a new ManagerPage and find all the elements
    3-Click AddCustomer Button and fill the blanks
    4-Validate the pop-up contains "Customer added successfully"
    5-Click Ok button
    6-Create BankManagerTest Class and call the method
      -->One from LoginPage (click)
      -->One from ManagerPage (all the actions)
    NOTE:You can call the name of method -->ValidateAddCustomerFunctionality
     */

    public BankManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    WebElement addCustomerTop;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitCustomer;
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccount;
    @FindBy(css = "#userSelect")
    WebElement customerDropDown;
    @FindBy(css = "#currency")
    WebElement currencyDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;
    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement customerButton;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomer;
    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;
    @FindBy(css = "#userSelect")
    WebElement yourNameDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement deposit;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement depositSuccessful;
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawl;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawnAmount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement transactionSuccessful;

    public void addCustomerFunctionality(WebDriver driver, String firstName, String lastName, String postCode, String expectedMessage) {
        addCustomerTop.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitCustomer.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void openAccountFunctionality(WebDriver driver, String customerName, String currency, String expectedMessage) {
        openAccount.click();
//        Select options = new Select(customerDropDown);
//        options.selectByVisibleText("Ash Zab");
//        Select options2 = new Select(currencyDropDown);
//        options2.selectByValue("Dollar");
        BrowserUtils.selectBy(this.customerDropDown, customerName, "text");
        BrowserUtils.selectBy(this.currencyDropDown, currency, "value");
        processButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void customerSearchFunctionality(String name, String lastName, String postCode) {
        customerButton.click();
        this.searchCustomer.sendKeys(name);
        List<String> expectNames = Arrays.asList(name, lastName, postCode);
        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectNames.get(i));
        }
    }
}
