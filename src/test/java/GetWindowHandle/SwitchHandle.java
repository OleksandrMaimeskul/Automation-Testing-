package GetWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;

public class SwitchHandle {
    @Test
    public void switchWindow() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        Actions actions = new Actions(driver);

        WebElement clickHere = driver.findElement(By.xpath("//div[@class='example']//a[@target='_blank']"));
        clickHere.click();
        Set<String> allPagesUID = driver.getWindowHandles();
        for (String pageId : allPagesUID) {
            driver.switchTo().window(pageId);
            if (driver.getTitle().contains("New Window")) {
                break;
            }
        }
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

        for (String pageId : allPagesUID) {
            driver.switchTo().window(pageId);
            if (driver.getTitle().contains("The Internet")) {
                break;
            }
        }
        WebElement header2 = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header2));
    }

    @Test
    public void switchPractice() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/about')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");

        /*
        1 - Go to About print out header
        2- Go to Contact us print out header
3-Go to KickStart and print out header
         */
        BrowserUtils.switchWindow(driver,"About");
        WebElement headerAbout = driver.findElement(By.xpath("//h2[@id='el_1643722365300_463']"));
        System.out.println(BrowserUtils.getText(headerAbout));

        BrowserUtils.switchWindow(driver, "Contact us");

        WebElement contactUsHeader = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(contactUsHeader));

        BrowserUtils.switchWindow(driver, "Kickstart");

        WebElement kickstartHeaser = driver.findElement(By.xpath("//b[contains(text(), 'LAUNCH')]"));
        System.out.println(BrowserUtils.getText(kickstartHeaser));
        driver.quit();

    }
}
