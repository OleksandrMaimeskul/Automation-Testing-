package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeMainPage;
import com.qa.blaze.pages.CartPage;
import com.qa.blaze.pages.LoginPage;
import com.qa.blaze.pages.PlaceOrderPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeOrderTest extends BlazeTestBase{

    @Test
    public void validateOrderFunct() throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        blazeMainPage.loginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logInFunctionality(ConfigReader.readProperty("blazeUserName"), ConfigReader.readProperty("blazePassword"),
                ConfigReader.readProperty("blazeExpectedMessage"));

        /*
     1-Login succesfully
     2-Choose laptop from category and choose MacBook Pro
     3-Click Add the cart
     4-Click Cart button from top
     5-Click Place Order
     6-Fill all the blanks(Order Page)
     7-validate Thanks message and click Ok button
     8-Validate url
         */

        CartPage cartPage = new CartPage(driver);
        cartPage.setCartButton();

        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.placeOrderPage(driver, ConfigReader.readProperty("blazeName"),
                ConfigReader.readProperty("blazeCountry"), ConfigReader.readProperty("blazeCity"),
                ConfigReader.readProperty("blazeCard"), ConfigReader.readProperty("blazeMonth"),
                ConfigReader.readProperty("blazeYear"),"Thank you for your purchase!",
                "https://www.demoblaze.com/index.html");
    }
}
