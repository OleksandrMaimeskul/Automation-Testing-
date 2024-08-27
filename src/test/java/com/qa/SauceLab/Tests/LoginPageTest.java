package com.qa.SauceLab.Tests;

import com.qa.SauceLab.Pages.LoginPage;
import com.qa.SauceLab.Pages.LoginPageDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends SauceTestBase {
    @Test(dataProvider="loginAndPassword", dataProviderClass = LoginPageDataProvider.class)
    public void checkOfLoginFunctionality(String username, String password, String url) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterData(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test(dataProvider="negativeScenario", dataProviderClass = LoginPageDataProvider.class)
    public void checkOfIncorrectData(String username, String password, String textWrongLogin) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.wrongLogin(username,password,textWrongLogin);

    }


}
