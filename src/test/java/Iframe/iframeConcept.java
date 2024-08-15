package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class iframeConcept {

    @Test
    public void iframePractice() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement button4 = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));

        WebElement geader = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(geader));

        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        System.out.println(BrowserUtils.getText(text));
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
    }

    @Test
    public void practiceIframe() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        /*
          TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links) and validate size is 22
*/
        WebElement pavillionButton = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavillionButton.click();
        BrowserUtils.switchWindow(driver, "qavalidation");

        BrowserUtils.switchWindow(driver, "iframes");
        BrowserUtils.switchWindow(driver, "qavalidation");
        driver.navigate().refresh();

        WebElement seleniumButton = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(seleniumButton).perform();

        WebElement seleniumPhyton = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
        seleniumPhyton.click();

        List<WebElement> links = driver.findElements(By.xpath("//p//a"));
        System.out.println(links);
        Assert.assertEquals(links.size(),22);

/*
        TASK2:
        1-Click the category 1 button
        2-Validate the header is "Category Archives: SeleniumTesting"
        3-Print out the top of the each box(text) and validate size is 9 I showed you during manual steps

        TASK3:
        1-Go to the iframe tab
        2-print out "I am inside Frame"
        3-Click category 3
        4-print out the header "Category Archives: SoftwareTesting"
                */
    }
}