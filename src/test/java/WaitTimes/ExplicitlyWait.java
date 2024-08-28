package WaitTimes;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.sql.Driver;
import java.time.Duration;
import java.util.NoSuchElementException;

public class ExplicitlyWait {
    /*
    1-It is a way to handle wait time issue in Selenium
    2-We need to create an object
    3-We need to provide condition
     */
    @Test
    public void explicitlyWait(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        webDriverWait.until(ExpectedConditions.visibilityOf(helloWorld));
        System.out.println(BrowserUtils.getText(helloWorld));
    }

    @Test
    public void fluentWait(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        button.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(3))
                .withMessage("Text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        WebElement text = fluentWait.until(mydriver->driver.findElement(By.cssSelector("#message")));

//        WebElement text = driver.findElement(By.cssSelector("#message"));
        System.out.println(BrowserUtils.getText(text));
    }
}
