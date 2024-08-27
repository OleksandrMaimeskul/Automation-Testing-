package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BankLoginTest extends BankTestBase {

    /*
    1. In test class we have our @Test annotations
     */


    @Test
    public void validateLoginInformation() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.checkLoginPageInformation(driver, "XYZ Bank",
                "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        bankLoginPage.clickManagerLoginButton();

    }
}