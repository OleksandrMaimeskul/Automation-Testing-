package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.awt.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MidLevelPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        /*
1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4)

 NOTE:Your test should fail
 NOTE2:You can use any select method value,visibleText
 */

        WebElement typeOfTrip = driver.findElement(By.xpath("//input[@value='oneway']"));
        typeOfTrip.click();

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
//        Select choosePassenger = new Select(passengers);
//        choosePassenger.selectByValue("4");
        BrowserUtils.selectBy(passengers, "4", "text");
        WebElement defaultValue = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select deffaultOpt = new Select(defaultValue);
        String defaultOPtion = deffaultOpt.getFirstSelectedOption().getText().trim();
        String expectedAccapulco = "Acapulco";
        Assert.assertEquals(defaultOPtion, expectedAccapulco);

        deffaultOpt.selectByValue("Paris");

        WebElement month = driver.findElement(By.xpath("//select[@name='fromMonth']"));
//        Select monthToChoose = new Select(month);
//        monthToChoose.selectByValue("8");
        BrowserUtils.selectBy(month, "7", "index");
        WebElement date = driver.findElement(By.xpath("//select[@name='fromDay']"));
//        Select dateToChoose = new Select(date);
//        dateToChoose.selectByValue("15");
        BrowserUtils.selectBy(date, "15", "index");
        WebElement arriveTo = driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select arriveToCity = new Select(arriveTo);
//        arriveToCity.selectByValue("San Francisco");
        BrowserUtils.selectBy(arriveTo, "San Francisco", "text");
        WebElement monthOfArrival = driver.findElement(By.xpath("//select[@name='toMonth']"));
//        Select monthToChooseOfArrival = new Select(monthOfArrival);
//        monthToChooseOfArrival.selectByValue("12");
        BrowserUtils.selectBy(monthOfArrival, "December", "text");

        WebElement dateOfArrival = driver.findElement(By.xpath("//select[@name='toDay']"));
//        Select dateToChooseOfArrival = new Select(dateOfArrival);
//        dateToChooseOfArrival.selectByValue("15");
        BrowserUtils.selectBy(dateOfArrival, "15", "index");
        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        Select allArlines = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
        List<WebElement> allOptions = allArlines.getAllSelectedOptions();
        List<String> expectedOPtions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertEquals(allOptions.get(i).getText().trim(), expectedOPtions.get(i));
        }
        Thread.sleep(3000);
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement titleName = driver.findElement(By.xpath("//b/font[@size='4']"));
        String actualTitleName = titleName.getText().trim();
        String expectedTitleName = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(actualTitleName, expectedTitleName);
        driver.quit();
    }
}
