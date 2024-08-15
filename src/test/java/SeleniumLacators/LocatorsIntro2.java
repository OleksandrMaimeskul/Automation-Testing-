package SeleniumLacators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/mayme/Downloads/Techtorialwebsite.html");

        //LOCATOR TAGNAME
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LOCATOR : LINKTEXT

        WebElement javaButton = driver.findElement(By.linkText("Java"));
        javaButton.click();

        WebElement headerJava = driver.findElement(By.tagName("h1"));
        String actualHeader = headerJava.getText();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement selenium = driver. findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement headerSelenium = driver.findElement(By.tagName("h1"));
        System.out.println(headerSelenium.getText());
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        Thread.sleep(2000);
        WebElement headerCucumber = driver.findElement(By.tagName("h1"));
        System.out.println(headerCucumber.getText());
        driver.navigate().back();
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        // LOCATOR : PARTIAL LINK TEST
        WebElement restAPI = driver.findElement(By.partialLinkText("Rest"));
        restAPI.click();
        Thread.sleep(2000);
        driver.navigate().back();

        //Locator: CSS

        WebElement header2 = driver.findElement(By.cssSelector("#techtorial1"));
        System.out.println(header2.getText());

        WebElement allTools2= driver.findElement(By.cssSelector(".group_checkbox"));
        System.out.println(allTools2.getText());

        driver.quit();
    }
}
