package com.qa.blaze.tests;

import com.qa.blaze.pages.ProductPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProductPageTest extends BlazeTestBase{
    @Test
    public void validateOfMackBookProduct() throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);
        productPage.laptopCategory();
        Thread.sleep(1000);
        productPage.exactLaptop(driver);
        Thread.sleep(1000);
        productPage.validateProduct(driver, ConfigReader.readProperty("blazeHeader"), ConfigReader.readProperty("blazePrice"),
                ConfigReader.readProperty("blazeDescription"), ConfigReader.readProperty("blazeProductAdded"));


    }
}
