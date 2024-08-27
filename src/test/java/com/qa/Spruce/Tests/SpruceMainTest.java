package com.qa.Spruce.Tests;

import com.qa.Spruce.Pages.SeafoodPAge;
import com.qa.Spruce.Pages.SpruceMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpruceMainTest extends SpruceBaseTest  {
    @Parameters({"search","cardTitle"})
    @Test
    public void mainPageToFishAndSeafood(String search, String cardTitle) throws InterruptedException {
        SpruceMainPage spruceMainPage = new SpruceMainPage(driver);
        spruceMainPage.setIngredientsButton(driver);
        spruceMainPage.setFishAndSeafood();
        SeafoodPAge seafoodPAge = new SeafoodPAge(driver);
        seafoodPAge.enterInfo(driver,search ,cardTitle);
    }
}
