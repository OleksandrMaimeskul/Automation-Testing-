package com.qa.SauceLab.Tests;

import com.qa.SauceLab.Pages.InventoryPage;
import com.qa.SauceLab.Pages.LoginPage;
import com.qa.SauceLab.Pages.LoginPageDataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class InventoryTest extends  SauceTestBase {
    @Test(dataProvider = "AllItems", dataProviderClass = LoginPageDataProvider.class)
    public void validateProductInfo(String title, String description, String price) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterData((ConfigReader.readProperty("sauceUserName")),ConfigReader.readProperty("saucePassword"));

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkEachItem(title);
        inventoryPage.itemInfo(description,price);




    }
}
