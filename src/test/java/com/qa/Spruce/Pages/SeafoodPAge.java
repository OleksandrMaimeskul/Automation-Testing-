package com.qa.Spruce.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.security.Key;
import java.security.SecureRandom;

public class SeafoodPAge {
    public SeafoodPAge(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@aria-label='Search Input']")
    WebElement searchLine;
    @FindBy(xpath = "//button[@id='search-form__btn_1-0']")
    WebElement searchButton;

    @FindBy(xpath = "//label[@for='starRating_score_4Star']")
    WebElement fourStart;

    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorChoice;
    @FindBy(xpath = "//span[.='6-Ingredient Roasted Salmon Fillets']")
    WebElement cardTitle;

    public void enterInfo(WebDriver driver, String search, String cardTitle) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver, searchLine);
        searchLine.sendKeys(search, Keys.ENTER);
        Thread.sleep(1000);
        searchButton.click();
        fourStart.click();
        editorChoice.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(this.cardTitle),cardTitle);

    }

}
