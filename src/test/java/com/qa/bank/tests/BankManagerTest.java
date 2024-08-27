package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankManagerPage;
import org.junit.Test;
import org.testng.annotations.Parameters;

public class BankManagerTest extends BankTestBase {
@Parameters({"firstName", "lastName", "postCode"})
    @Test
    public void validateCustomerFunctionality(String firstName, String lastName, String postCode){
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerLoginButton();


        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,firstName,lastName,postCode,"Customer added successfully");

        bankManagerPage.openAccountFunctionality(driver,"Oleksandr Maimeskul","Dollar","Account created successfully");
        bankManagerPage.customerSearchFunctionality(firstName,lastName,postCode);

    }

}