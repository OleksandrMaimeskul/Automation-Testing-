package JavaScriptExecutorClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {
    @Test
    public void practiceJSClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement buttonYes = driver.findElement(By.xpath("//input[@ id='yesRadio']"));
//        buttonYes.click();
//        Actions actions = new Actions(driver);
//        actions.scrollByAmount(300,300).perform();
//        Thread.sleep(1000);
//        actions.click(buttonYes).perform();
        BrowserUtils.clickWithJS(driver, buttonYes);

//        WebElement text = driver.findElement(By.xpath("//p[@ class='mt-3']"));
//        String actualText = BrowserUtils.getText(text);
//        String expectedText = "You have selected";
//        Thread.sleep(1000);
//        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver, copyRight);
        Thread.sleep(2000);
        WebElement top = driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
        BrowserUtils.scrollWithJS(driver, top);
    }

    @Test
    public void practiceJSAndScroll() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement toDown = driver.findElement(By.xpath("//div[@ id = 'el_1666192783860_472']"));
        BrowserUtils.scrollWithJS(driver, toDown);
        Thread.sleep(1000);
        String text1 = BrowserUtils.getText(toDown);
        String expectedText = "Corporate Training";
        Assert.assertEquals(text1, expectedText);

        WebElement top = driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
        BrowserUtils.scrollWithJS(driver, top);
        Thread.sleep(1000);
        WebElement applyButton = driver.findElement(By.xpath("//li[@ class = 'lw-topbar-option']//a[@id='menuItem_1594985863854_2']"));
        BrowserUtils.clickWithJS(driver, applyButton);

        List<WebElement> validateInfo = driver.findElements(By.xpath("//div[@class='col span_4_of_12 span_4_of_12-tl span_4_of_12-tp span_12_of_12-sl mb-4rem-sl span_12_of_12-sp mb-4rem-sp flex-item flexible js-same-content-child lw-body-bg']"));
        List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");

        for (int i = 0; i < validateInfo.size(); i++) {
            Assert.assertEquals(validateInfo.get(i).getText().trim(), expectedInfo.get(i));
        }
        driver.quit();
    }
}
