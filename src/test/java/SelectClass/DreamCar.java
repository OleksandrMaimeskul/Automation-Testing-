package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New & certified" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
6-Choose the distance 40 miles
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header contains  "New and certified Lexus RX 350 for sale"
11-Validate the all titles has Lexus RX 350
 */
    //TEST CASE : searchFunctionality

    // https://www.cars.com/shopping/

    @Test
    public void validateCars() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.cars.com/shopping/");
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        WebElement newUsed = driver.findElement(By.xpath("//select[@ id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed, "new_cpo", "value");
        WebElement make = driver.findElement(By.xpath("//select[@ id='makes']"));
        BrowserUtils.selectBy(make, "lexus", "value");
        WebElement models = driver.findElement(By.xpath("//select[@ id='models']"));
        BrowserUtils.selectBy(models, "lexus-rx_350", "value");
        WebElement price = driver.findElement(By.xpath("//select[@ id='make-model-max-price']"));
        Select noMaxPrice = new Select(price);
        Assert.assertEquals(noMaxPrice.getFirstSelectedOption().getText().trim(), "No max price");
        WebElement distance = driver.findElement(By.xpath("//select[@ id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");
        WebElement zipCode = driver.findElement(By.xpath("//input[@ id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("77339");
        WebElement buttonSearch = driver.findElement(By.xpath("//hubcap-button[@data-searchtype='make']"));
        buttonSearch.click();
        Thread.sleep(3000);
        WebElement header = driver.findElement(By.xpath("//h1[@class='spark-heading-1 sds-page-section__title']"));
        Assert.assertTrue(header.getText().trim().contains("New and certified used Lexus RX 350 for sale near"));
        List<WebElement> allTitles = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement eachTitle : allTitles) {
            Assert.assertTrue(eachTitle.getText().trim().contains("Lexus RX 350"));
        }
        driver.quit();
    }
}
