package com.qa.Spruce.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class SpruceMainPage {
    public SpruceMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredientsButton;

    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishAndSeafood;

    public void setIngredientsButton(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(ingredientsButton).perform();
    }
    public void setFishAndSeafood() {
       fishAndSeafood.click();

    }

}
