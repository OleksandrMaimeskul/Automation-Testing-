package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class PlaceOrderPage {

    public PlaceOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-target='#orderModal']")
    WebElement placeOrderButton;

    @FindBy(css = "#name")
    WebElement name;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement card;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement validateThanksMsg;

    @FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
    WebElement okButton;

    public void placeOrderPage(WebDriver driver, String name, String country, String city, String creditCard, String month,
                               String year, String expectedThankYouMsg, String expecteUrl) throws InterruptedException {
        placeOrderButton.click();
        Thread.sleep(1000);
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        Thread.sleep(1000);
        this.city.sendKeys(city);
        Thread.sleep(1000);
        this.card.sendKeys(creditCard);
        Thread.sleep(1000);
        this.month.sendKeys(month);
        Thread.sleep(1000);
        this.year.sendKeys(year);
        Thread.sleep(1000);
        purchaseButton.click();
        Assert.assertEquals(BrowserUtils.getText(validateThanksMsg), expectedThankYouMsg);
        Thread.sleep(1000);
        okButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), expecteUrl);
    }

}
