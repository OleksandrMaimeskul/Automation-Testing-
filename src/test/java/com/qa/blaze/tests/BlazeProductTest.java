package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeMainPage;
import com.qa.blaze.pages.LoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeProductTest extends BlazeTestBase {
    @Test
    public void validateProductInfo() throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        blazeMainPage.loginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInFunctionality(ConfigReader.readProperty("blazeUserName"), ConfigReader.readProperty("blazePassword"),
                ConfigReader.readProperty("blazeExpectedMessage"));


    }

}
