package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;


public class ProductPage {
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#itemc")
     List<WebElement> allProducts;
    @FindBy(css = ".hrefch")
    List<WebElement> laptops;
    @FindBy(xpath = "//h2")
    WebElement headerMac;
    @FindBy(xpath = "//h3")
    WebElement priceWithTax;
    @FindBy(xpath = "//div[@id='more-information']//p")
    WebElement descriptionWithMacContains;
    @FindBy(xpath = "//a[@onclick='addToCart(15)']")
    WebElement addToCartButton;

    public void laptopCategory() {
        for (WebElement laptop : allProducts) {
            if (laptop.getText().contains("Laptops")) {
                laptop.click();
                break;
            }
        }
    }

    public void exactLaptop(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(400, 400).perform();
        for (WebElement macBook : laptops) {
            if (macBook.getText().contains("MacBook Pro")) {
                macBook.click();
                break;
            }
        }
    }

    public void validateProduct(WebDriver driver, String header, String price, String description, String productAdded) throws InterruptedException {
        Assert.assertTrue(BrowserUtils.getText(headerMac).contains(header));
        Thread.sleep(1000);
        Assert.assertTrue(BrowserUtils.getText(priceWithTax).contains(price));
        Thread.sleep(1000);
        Assert.assertTrue(BrowserUtils.getText(descriptionWithMacContains).contains(description));
        Thread.sleep(1000);
        addToCartButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), productAdded);
        alert.accept();
        Thread.sleep(3000);
    }

}
