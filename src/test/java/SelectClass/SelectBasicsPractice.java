package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectBasicsPractice {
    @Test
    public void practiceMethod() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/mayme/Downloads/Techtorialwebsite.html");

        /*
        1-Validate the default value is "UNITED STATES"
        2-Choose Your own country with "VisibleText" Method Thread.sleep to see how it is changing
        3-Choose your favorite country with "value" method Thread.sleep
        4-Choose the country you do not want to visit "index" Thread.sleep
        5-Validate the number of countries is 264
        6-Print out all the countries
        7-driver.quit()
         */
        WebElement country = driver.findElement(By.xpath("//select[@name = 'country']"));
        Select values = new Select(country);
        String defaultValue = values.getFirstSelectedOption().getText().trim();
        String expectedValue = "UNITED STATES";
        Assert.assertEquals(defaultValue, expectedValue);

        values.selectByVisibleText("UKRAINE ");
        Thread.sleep(3000);
        values.selectByValue("134");
        Thread.sleep(3000);
        values.selectByIndex(3);




    }
}
