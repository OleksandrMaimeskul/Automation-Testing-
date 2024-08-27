package com.qa.SauceLab.Pages;

import org.testng.annotations.DataProvider;

public class LoginPageDataProvider{


@DataProvider(name = "loginAndPassword")
    public Object[][] dataProvider () {
    return new Object[][]{
            {"standard_user", "secret_sauce","https://www.saucedemo.com/inventory.html"},
            {"problem_user", "secret_sauce","https://www.saucedemo.com/inventory.html"},
            {"performance_glitch_user", "secret_sauce","https://www.saucedemo.com/inventory.html"},
            {"error_user", "secret_sauce","https://www.saucedemo.com/inventory.html"},
            {"visual_user", "secret_sauce","https://www.saucedemo.com/inventory.html"}
    };
    }
    @DataProvider(name = "negativeScenario")
    public Object[][] negativeScenario () {
        return new Object[][]{
                {"standard_user", "secret_sauc","Epic sadface: Username and password do not match any user in this service"},
                {"problem_user", "","Epic sadface: Password is required"},
                {"", "secret_sauce","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce", "Epic sadface: Sorry, this user has been locked out."},

        };
    }
    @DataProvider(name = "AllItems")
    public Object[][] validateAllItmesDescrAndPrice () {
        return new Object[][]{
                {"Sauce Labs Backpack", "Sly Pack","$29.99"},
                {"Sauce Labs Bike Light", "1 AAA battery","$9.99"},
                {"Sauce Labs Bolt T-Shirt", "American Apparel","$15.99"},
                {"Sauce Labs Fleece Jacket", "quarter-zip fleece jacket","$49.99"},
                {"Sauce Labs Onesie", "Reinforced 3-snap bottom closure","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "Sauce Labs t-shirt is perfect ","$15.99"},


        };
    }

}