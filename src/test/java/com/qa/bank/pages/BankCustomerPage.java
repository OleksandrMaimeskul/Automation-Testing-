package com.qa.bank.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class BankCustomerPage {

    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#userSelect")
    WebElement yourNameDropDown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement button;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;
    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement transcationMesssage;
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawlButton;
    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;
    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionsButton;
    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding'][2]")
    WebElement firstTransaction;
    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding'][2]")
    WebElement secondTransaction;
    @FindBy(xpath = "//button[@ng-click='byebye()']")
    WebElement logOutButton;

    public void transactionFunctionality(WebDriver driver, String customerName, String expectedWelcomeMessage,String depositAmount,
                                         String depositMessage, String expectedColor, String withDrawlAmount, String withdrawMessage, String expectedUrl) throws InterruptedException {
        BrowserUtils.selectBy(this.yourNameDropDown,customerName,"text");
        button.click(); // loginButton
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage),expectedWelcomeMessage);
        depositButton.click();
        Thread.sleep(1000);
        amount.sendKeys(depositAmount);
        button.click();  // depositButton
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(transcationMesssage), depositMessage);
        Assert.assertEquals(transcationMesssage.getCssValue("color"),expectedColor);
        withdrawlButton.click();
        Thread.sleep(1000);
        amount.sendKeys(withDrawlAmount);
        button.click(); // withDrawlButton
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(transcationMesssage), withdrawMessage);
        Assert.assertEquals(transcationMesssage.getCssValue("color"),expectedColor);
        int expectedBalance = Integer.parseInt(BrowserUtils.getText(this.balance));
        transactionsButton.click();
        Thread.sleep(1000);
        int resultBalance = Integer.parseInt(BrowserUtils.getText(firstTransaction)) -
                Integer.parseInt(BrowserUtils.getText(secondTransaction));

        Assert.assertEquals(resultBalance,expectedBalance);
        logOutButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);


    }
}