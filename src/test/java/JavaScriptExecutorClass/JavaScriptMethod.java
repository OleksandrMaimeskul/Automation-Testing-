package JavaScriptExecutorClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class JavaScriptMethod {

    /*
    NOTE:JavaScript is a programming Language Like Java
    NOTE:JavaScript method should be your "Last Option" if regular Selenium methods are not working
     */
    @Test
    public void clickJS(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement aboutUs = driver.findElement(By.xpath("//span[.='About Us']"));
        //aboutUs.click() // First try regular click
//        Actions actions = new Actions(driver);  // Second may is clicking with actions
//        actions.click(aboutUs).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }
}
