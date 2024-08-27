package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeSignUpPage;
import com.qa.blaze.pages.BlazeMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeMainTest extends BlazeTestBase {
    @Parameters("userName")
    @Test
    public void validateSignUpFunct(String userName) throws InterruptedException {
        BlazeMainPage signUpPage = new BlazeMainPage(driver);
        signUpPage.signUpButton();

        BlazeSignUpPage blazeSignUpPage = new BlazeSignUpPage(driver);
        blazeSignUpPage.signUpFunctionality(driver, userName, "Oleksandr5351133",
                "Sign up successful.");

    }

}
