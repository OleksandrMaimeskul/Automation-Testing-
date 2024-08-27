package com.qa.bank.tests;

import com.qa.bank.pages.BankCustomerPage;
import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;

public class BankCustomerTest extends BankTestBase {

    @Test
    public void validateBankTransactionFunctionality() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,
                ConfigReader.readProperty("firstName"),
                ConfigReader.readProperty("lastName"),
                ConfigReader.readProperty("postCode"),
                ConfigReader.readProperty("customerMessage"));

        bankManagerPage.openAccountFunctionality(driver,
                ConfigReader.readProperty("customerName"),
                ConfigReader.readProperty("currency"),
                ConfigReader.readProperty("accountMessage"));
        bankManagerPage.customerSearchFunctionality
                (ConfigReader.readProperty("firstName"),
                        ConfigReader.readProperty("lastName"),
                        ConfigReader.readProperty("postCode"));


        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerLoginButton();

        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankCustomerPage.transactionFunctionality(driver,"Oleksandr Maimeskul",
                "Welcome Oleksandr Maimeskul !!","800",
                "Deposit Successful","rgba(255, 0, 0, 1)","200",
                "Transaction successful",
                "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }

}